package work.beancopy;

import cn.hutool.core.collection.CollectionUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

/**
 * Bean属性对拷工具类
 */
@Slf4j
public final class BeanUtil {

    private static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    private BeanUtil() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 浅拷贝成hashset
     */
    public static final int COPY_TO_HASHSET = 1;
    /**
     * 浅拷贝成arrayList
     */
    public static final int COPY_TO_ARRAYLIST = 2;

    /**
     * 使用cglib实现高性能浅对象拷贝, 理论上性能是apache和spring beanutil 100倍以上<br/>
     * 缺点:属性和类型必须一致，而且必须要有getter和setter方法, 否则无法拷贝，<br/>
     * 参阅: <br/>
     * https://blog.csdn.net/SJZYLC/article/details/81203086 <br/>
     * https://www.e-learn.cn/content/qita/1733178
     *
     * @param source
     * @param target
     */
    public static void copyShallow(Object source, Object target) {
        if (source == null || target == null) {
            return;
        }
        BeanCopier beanCopier = BeanCopierGenerator.getBeanCopier(source.getClass(), target.getClass());
        beanCopier.copy(source, target, null);
    }

    /**
     * Collection高性能集合类对象转换，浅拷贝
     * {@link #COPY_TO_HASHSET}  {@link #COPY_TO_ARRAYLIST}
     *
     * @param sourceCollection 源集合对象
     * @param sourceClass      源集合对象类信息
     * @param targetClass      目标对象类信息, 必须要有空构造器
     * @param copyType
     * @return
     */
    public static Collection copyCollectionShallow(Collection sourceCollection, Class sourceClass,
                                                   Class targetClass, int copyType) {
        Collection targetCollection = null;
        if (CollectionUtil.isEmpty(sourceCollection)) return targetCollection;
        BeanCopier beanCopier = BeanCopierGenerator.getBeanCopier(sourceClass, targetClass);
        switch (copyType) {
            case COPY_TO_HASHSET:
                targetCollection = new HashSet(sourceCollection.size());
                break;
            case COPY_TO_ARRAYLIST:
                targetCollection = new ArrayList(sourceCollection.size());
                break;
            default:
                throw new IllegalArgumentException("copyType is not right");
        }
        for (Object source : sourceCollection) {
            try {
                Object targetObject = targetClass.newInstance();
                beanCopier.copy(source, targetObject, null);
                targetCollection.add(targetObject);
            } catch (IllegalAccessException | InstantiationException e) {
                logger.warn("copyCollectionShallow error", e);
            }
        }
        return targetCollection;
    }

    /**
     * List高性能集合类对象转换，浅拷贝
     *
     * @param sourceCollection 源集合对象
     * @param sourceClass      源集合对象类信息
     * @param targetClass      目标对象类信息, 必须要有空构造器
     * @return
     */
    public static <T> List<T> copyListShallow(Collection sourceCollection, Class sourceClass,
                                              Class<T> targetClass) {
        return (List<T>) copyCollectionShallow(sourceCollection, sourceClass, targetClass, COPY_TO_ARRAYLIST);
    }

    /**
     * Set高性能集合类对象转换，浅拷贝
     *
     * @param sourceCollection 源集合对象
     * @param sourceClass      源集合对象类信息
     * @param targetClass      目标对象类信息, 必须要有空构造器
     * @return
     */
    public static <T> Set<T> copySetShallow(Collection sourceCollection, Class sourceClass,
                                            Class<T> targetClass) {
        return (Set<T>) copyCollectionShallow(sourceCollection, sourceClass, targetClass, COPY_TO_HASHSET);
    }

    /**
     * 利用对象流实现对象深拷贝
     */
    public static <T> T copyDeep(T source) {
        if (source == null) {
            return null;
        }
        try {
            //序列化
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(source);

            //反序列化
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (T) ois.readObject();
        } catch (Exception e) {
            log.warn("copyDeep failed", e);
        }
        return null;
    }

    /**
     * 利用cglib框架实现对象转Map, 比反射性能要快很多
     */
    public static Map obj2Map(Object source) {
        if (source == null) {
            return null;
        }
        return BeanMap.create(source);
    }

    /**
     * 利用cglib框架实现list对象转List<Map></Map>, 比反射性能要快很多
     */
    public static List<Map> list2ListMap(List sourceList) {
        if (CollectionUtil.isEmpty(sourceList)) {
            return Lists.newArrayList();
        }
        List<Map> retList = new ArrayList<>(sourceList.size());
        sourceList.forEach(e -> retList.add(BeanMap.create(e)));
        return retList;
    }

    /**
     * 用spring beanutil实现的，非空属性对拷，!!!请注意只能实现一层属性的非空判断!!!!，对象套对象是无法实现内部对象属性非空对拷的
     */
    public static void copyPropertiesIgnoreNull(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public static <T> T toVoOrDto(Object source, Class<T> voClass) {
        T targetObj = null;
        if (null == source) {
            return null;
        }
        try {
            targetObj = voClass.newInstance();
            BeanUtil.copyShallow(source, targetObj);
        } catch (IllegalAccessException | InstantiationException e) {
            log.warn("invoke Th3rd toVO get error", e);
        }
        return targetObj;
    }

}
