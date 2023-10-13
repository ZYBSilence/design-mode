package work.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * @description: Jwt生成token工具类
 * @author: zyb
 * @date: 2023/9/27 16:02
 */
public class JwtUtils {
    /**
     * 秘钥
     */
    private static final SecretKey ACCESS_KEY_SECRET = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    /**
     * 签名签发者
     */
    private static final String ISSUER = "Silence";
    /**
     * 签名的预期接收者
     */
    private static final String AUDIENCE = "Silence";

    /**
     * 创建token
     *
     * @param subject 需加密信息
     * @return token
     */
    public static String createToken(String subject) {
        // 默认过期时间：1天
        return createToken(subject, 24 * 60 * 60 * 1000);
    }

    /**
     * 创建token
     *
     * @param subject          需加密信息
     * @param expirationMillis 过期时间（单位：毫秒）
     * @return token
     */
    public static String createToken(String subject, long expirationMillis) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expirationMillis);
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setIssuer(ISSUER)
                .setAudience(AUDIENCE)
                .setSubject(subject)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(ACCESS_KEY_SECRET).compact();
    }

    /**
     * 校验token信息
     *
     * @param token 加密token
     * @return true：解析成功
     */
    public static boolean verifyToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(ACCESS_KEY_SECRET).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 解析token获取加密主题
     *
     * @param token 加密token
     * @return subject主题
     */
    public static String getSubjectFromToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(ACCESS_KEY_SECRET).build().parseClaimsJws(token);
            return claimsJws.getBody().getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String token = createToken("admin");
        System.out.println(token);
        System.out.println(verifyToken(token));
        System.out.println(getSubjectFromToken(token));
    }
}
