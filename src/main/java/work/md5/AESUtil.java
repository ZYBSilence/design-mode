package work.md5;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author jihao
 * @date 2021/3/1 15:07
 */
@Slf4j
public class AESUtil {

    public static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
                    16);
        }
        return b;
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }


    public static void main(String[] args) {
        try {
            String encrypt = encrypt("132", "dddddsssssaaaaaa");
            System.out.println(encrypt);
            String decrypt = decrypt(encrypt, "dddddsssssaaaaaa");
            System.out.println(decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 加密
    public static String encrypt(String sSrc, String sKey)  {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] encrypted = null;
        try {
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
           encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    /*public static String encrypt(String data, String key) {
        if (StringUtils.isBlank(data) || StringUtils.isBlank(key)) {
            log.info("参数和密钥不允许为空");
            return null;
        }
        if (key.length() != 16) {
            log.info("加密key不满足条件");
            return null;
        }
        String strs = null;
        try {
            byte[] bytes = doAES(Cipher.ENCRYPT_MODE, data.getBytes(), key.getBytes());
            // base64编码字节
            strs = new String(Base64Utils.encode(bytes), "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("加密失败，errormsg={}", e.getMessage());
        }
        return strs;
    }*/

 /*   public static String decrypt(String data, String key) {
        if (StringUtils.isBlank(data) || StringUtils.isBlank(key)) {
            log.info("参数和密钥不允许为空");
            return null;
        }
        String strs = null;
        try {
            byte[] src = Base64Utils.decode(data.getBytes());
            byte[] bytes = doAES(Cipher.DECRYPT_MODE, src, key.getBytes());
            strs = new String(bytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            log.error("解密失败，errormsg={}", e.getMessage());
        }
        return strs;

    }*/

    public static String decrypt(String sSrc, String sKey)  {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

   /* public static byte[] doAES(int mode, byte[] data, byte[] key) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            kgen.init(128, new SecureRandom(key));
            //3.产生原始对称密钥
            SecretKey secretKey = kgen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] enCodeFormat = secretKey.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");// 创建密码器
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(mode, keySpec);// 初始化
            return cipher.doFinal(data);
        } catch (Exception e) {
            log.error("加解密失败，errormsg={}", e.getMessage());
        }
        return null;
    }
*/
}
