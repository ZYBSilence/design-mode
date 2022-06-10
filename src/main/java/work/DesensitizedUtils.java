package work;

/**
 * @description: 脱敏处理工具类
 * @author: zyb
 * @date: 2022/5/13 10:09
 */
public class DesensitizedUtils {
    /**
     * 对字符串进行脱敏操作
     *
     * @param origin          原始字符串
     * @param prefixNoMaskLen 左侧需要保留几位明文字段
     * @param suffixNoMaskLen 右侧需要保留几位明文字段
     * @param maskStr         用于遮罩的字符串, 如'*'
     * @return 脱敏后结果
     */
    public static String desValue(String origin, int prefixNoMaskLen, int suffixNoMaskLen, String maskStr) {
        if (origin == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0, n = origin.length(); i < n; i++) {
            if (i < prefixNoMaskLen) {
                sb.append(origin.charAt(i));
                continue;
            }
            if (i > (n - suffixNoMaskLen - 1)) {
                sb.append(origin.charAt(i));
                continue;
            }
            sb.append(maskStr);
        }
        return sb.toString();
    }

    /**
     * 银行卡脱敏处理
     *
     * @param cardNum 银行卡号
     * @return 脱敏处理银行卡号
     */
    public static String bankCard(String cardNum) {
        return desValue(cardNum, 4, 4, "*");
    }

    /**
     * 格式化-每四个字符用空格分开
     *
     * @param str 银行卡号
     * @return 脱敏处理格式化银行卡号
     */
    public String format(String str) {
        String regex = "(.{4})";
        str = str.replaceAll(regex, "$1 ").trim();    //去掉前后空格
        return str;
    }
}
