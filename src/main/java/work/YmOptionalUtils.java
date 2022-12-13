package work;

import lombok.experimental.UtilityClass;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Optional 工具类
 *
 * @author xukesheng
 */
@UtilityClass
public class YmOptionalUtils {

    public static <T> Optional<T> notNull(T o) {
        return Optional.ofNullable(o);
    }

    /**
     * if input is null or blank
     * return Optional.empty()
     * else
     * return Optional.of(value);
     */
    public static Optional<String> notBlank(String value) {
        return StringUtils.isBlank(value) ? Optional.empty() : Optional.of(value);
    }

    /**
     * if input is null or empty
     * return Optional.empty()
     * else
     * return Optional.of(value);
     */
    public static <T> Optional<Collection<T>> notEmpty(Collection<T> collection) {
        return CollectionUtils.isEmpty(collection) ? Optional.empty() : Optional.of(collection);
    }

    public static <T> Optional<List<T>> notEmptyList(List<T> list) {
        return CollectionUtils.isEmpty(list) ? Optional.empty() : Optional.of(list);
    }

    /**
     * if input is null or empty
     * return Optional.empty()
     * else
     * return Optional.of(value);
     */
    public static <K, V> Optional<Map<K, V>> notEmpty(Map<K, V> map) {
        return MapUtils.isEmpty(map) ? Optional.empty() : Optional.of(map);
    }

    public static <T> List<T> emptyOrNewArrayList(List<T> list) {
        return notEmptyList(list).orElse(new ArrayList<>());
    }

    public static <K, V> Map<K, V> emptyOrNewHashMap(Map<K, V> map) {
        return MapUtils.isEmpty(map) ? new HashMap<>() : map;
    }

    public static <T> T nullOrElse(T obj, T elseValue) {
        return Optional.ofNullable(obj).orElse(elseValue);
    }

    public static BigDecimal nullOrZero(BigDecimal decimal) {
        return Optional.ofNullable(decimal).orElse(BigDecimal.ZERO);
    }

    /**
     * 为空则返回0，否则返回原值
     */
    public static Integer nullAsIntZero(Integer decimal) {
        return Optional.ofNullable(decimal).orElse(0);
    }

    /**
     * 为空则返回0，否则返回原值
     */
    public static Long nullAsLongZero(Long decimal) {
        return Optional.ofNullable(decimal).orElse(0L);
    }

    public static <T> List<T> nullOrEmptyList(List<T> list) {
        return notEmptyList(list).orElse(Collections.emptyList());
    }

    public static String blankOrElse(String value, String other) {
        return StringUtils.isBlank(value) ? other : value;
    }

    public static <T> List<T> emptyOrElse(List<T> list, List<T> other) {
        return notEmptyList(list).orElse(other);
    }

    public static Optional<Boolean> isTrue(Boolean bool) {
        return bool == null || !bool ? Optional.empty() : notNull(bool);
    }
}
