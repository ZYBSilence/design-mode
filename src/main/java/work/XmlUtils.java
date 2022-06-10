package work;

import cn.hutool.core.util.XmlUtil;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;

/**
 * @description:
 * @author: zyb
 * @date: 2022/5/10 16:40
 */
public class XmlUtils extends XmlUtil {
    /**
     * xml字符串转为bean
     *
     * @param xml   xml字符串
     * @param clazz 需要转成的对象
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T parseBean(String xml, Class<T> clazz) {
        /*try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }*/
        StringReader reader = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new StringReader(xml);
            @SuppressWarnings("unchecked")
            T t = (T) unmarshaller.unmarshal(reader);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return null;
    }

    /**
     * 将对象转为xml字符串
     * 编码为utf-8
     * 不格式化
     * 省略头部声明
     *
     * @param obj 待转的对象
     * @return
     */
    public static String toStr(Object obj) {
        return toStr(obj, false, true);
    }

    /**
     * 将对象转为xml字符串
     * 编码为utf-8
     *
     * @param obj          待转的对象
     * @param isFormat     是否格式化
     * @param isIgnoreHead 是否忽略头部
     * @return
     */
    public static String toStr(Object obj, boolean isFormat, boolean isIgnoreHead) {
        StringWriter writer = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, isFormat);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, isIgnoreHead);// 是否省略xm头声明信息

            // 不进行转义字符的处理
            marshaller.setProperty(CharacterEscapeHandler.class.getName(),
                    new CharacterEscapeHandler() {
                        @Override
                        public void escape(char[] ch, int start, int length,
                                           boolean isAttVal, Writer writer) throws IOException {
                            writer.write(ch, start, length);
                        }
                    });

            writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将对象转为xml字符串
     * 编码为utf-8
     * 格式化
     * 省略头部声明
     *
     * @param obj 待转的对象
     * @return
     */
    public static String toPrettyStr(Object obj) {
        return toStr(obj, true, true);
    }


    /**
     * 将对象转为xml字符串
     * 编码为 GBK
     *
     * @param obj          待转的对象
     * @param isFormat     是否格式化
     * @param isIgnoreHead 是否忽略头部
     * @return
     */
    public static String toStrGF(Object obj, boolean isFormat, boolean isIgnoreHead) {
        StringWriter writer = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "GBK");// //编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, isFormat);// 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, isIgnoreHead);// 是否省略xm头声明信息
            // 不进行转义字符的处理
            marshaller.setProperty(CharacterEscapeHandler.class.getName(),
                    new CharacterEscapeHandler() {
                        @Override
                        public void escape(char[] ch, int start, int length,
                                           boolean isAttVal, Writer writer) throws IOException {
                            writer.write(ch, start, length);
                        }
                    });

            writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 对象转为xml文件
     *
     * @param obj
     * @param beanClass 对象的class
     * @return
     */
    public static String beanToXml(Object obj, Class<?> beanClass) {
        StringWriter writer = null;
        try {
            JAXBContext context = JAXBContext.newInstance(beanClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            writer = new StringWriter();
            marshaller.marshal(obj, writer);
            return writer.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}

