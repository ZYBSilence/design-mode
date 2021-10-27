package work.md5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description:
 * @author: zyb
 * @date: 2020/11/30 12:26
 */
public class FileMD5 {

    protected static MessageDigest messagedigest = null;

    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5FileUtil messagedigest初始化失败" + e);
        }
    }

    protected static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String getMd5ByFile(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        FileChannel ch = in.getChannel();
        MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
                file.length());
        messagedigest.update(byteBuffer);
        return bufferToHex(messagedigest.digest());
    }

    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    /**
     * @Description: 取得MD5加密字符串。
     * @param @param str 加密前的字符串
     * @param @return
     * @return String
     * @throws
     * @author pengzhihao
     * @date 2016-7-10下午5:20:37
     */
    public static String getMD5(String str) {
        String digest = "";
        try {
            if(str != null && !"".equals(str)){
                str = str.trim();
                MessageDigest currentAlgorithm = MessageDigest.getInstance("md5");
                currentAlgorithm.reset();
                byte[] mess = str.getBytes();
                byte[] hash = currentAlgorithm.digest(mess);
                for (int i = 0; i < hash.length; i++) {
                    int v = hash[i];
                    if (v < 0) {
                        v = 256 + v;
                    }
                    if (v < 16) {
                        digest += "0";
                    }
                    digest += Integer.toString(v, 16).toUpperCase() + "";
                }
            }
        } catch (Exception ex) {
            digest = str;
        }

        return digest;
    }


    public static String JM(String inStr) {
        byte[] a = inStr.getBytes();
        for (int i = 0; i < a.length; i++) {
            a[i] = (byte) (a[i] ^ 't');

        }
        return new String(a);
    }

    public static void main(String[] args) throws IOException {

//        String md5 = getMd5ByFile(new File("E:\\text\\技术书籍相关\\技术书籍相关.txt"));
//        System.out.println("MD5:" + md5);

        System.out.println(getMD5("123"));
        System.out.println(getMD5("123"));
        System.out.println(getMD5("123"));
    }

}
