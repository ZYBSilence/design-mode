package work.http;

import okhttp3.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @description: okHttp 工具类
 * @author: zyb
 * @date: 2023/10/12 9:50
 */
public class OkHttpUtils {
    private static final Logger logger = LoggerFactory.getLogger(OkHttpUtils.class);

    private static final OkHttpClient OK_HTTP_CLIENT;

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static final MediaType XML = MediaType.parse("application/xml; charset=utf-8");

    private static final long CONNECT_TIMEOUT = 30;

    private static final long READ_TIMEOUT = 15;

    private static final long WRITE_TIMEOUT = 15;

    static {
        OK_HTTP_CLIENT = new OkHttpClient.Builder()
                // 设置https配置，此处忽略了所有证书
                .sslSocketFactory(Objects.requireNonNull(createEasySSLContext()).getSocketFactory(), new EasyX509TrustManager(null))
                // 是否开启缓存
                .retryOnConnectionFailure(false)
                // 连接池配置
                .connectionPool(pool())
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .hostnameVerifier((hostname, session) -> true)
                .build();
    }

    /**
     * get 请求
     *
     * @param url 请求url地址
     * @return string
     */
    public static String doGet(String url) {
        return doGet(url, null, null);
    }


    /**
     * get 请求
     *
     * @param url    请求url地址
     * @param params 请求参数 map
     * @return string
     */
    public static String doGet(String url, Map<String, String> params) {
        return doGet(url, params, null);
    }

    /**
     * get 请求
     *
     * @param url     请求url地址
     * @param headers 请求头字段 {k1, v1 k2, v2, ...}
     * @return string
     */
    public static String doGet(String url, String[] headers) {
        return doGet(url, null, headers);
    }


    /**
     * get 请求
     *
     * @param url     请求url地址
     * @param params  请求参数 map
     * @param headers 请求头字段 {k1, v1 k2, v2, ...}
     * @return string
     */
    public static String doGet(String url, Map<String, String> params, String[] headers) {
        StringBuilder sb = new StringBuilder(url);
        if (params != null && params.keySet().size() > 0) {
            boolean firstFlag = true;
            for (String key : params.keySet()) {
                if (firstFlag) {
                    sb.append("?").append(key).append("=").append(params.get(key));
                    firstFlag = false;
                } else {
                    sb.append("&").append(key).append("=").append(params.get(key));
                }
            }
        }

        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.length > 0) {
            if (headers.length % 2 == 0) {
                for (int i = 0; i < headers.length; i = i + 2) {
                    builder.addHeader(headers[i], headers[i + 1]);
                }
            } else {
                logger.warn("headers's length[{}] is error.", headers.length);
            }

        }

        Request request = builder.url(sb.toString()).build();
        logger.info("do get request and url[{}]", sb.toString());
        return execute(request);
    }

    /**
     * post 请求
     *
     * @param url   请求url地址
     * @param param 请求参数
     * @return string
     */
    public static String doPost(String url, String param) {
        okhttp3.MediaType mediaType = okhttp3.MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, param);
        Request request = new Request.Builder().url(url).post(body).build();
        logger.info("okhttp do post request and url[{}]", url);
        return execute(request);
    }


    /**
     * post 请求, 请求数据为 json 的字符串
     *
     * @param url  请求url地址
     * @param json 请求数据, json 字符串
     * @return string
     */
    public static String doPostJson(String url, String json) {
        logger.info("do post request and url[{}]", url);
        return executePost(url, json, JSON);
    }

    /**
     * post 请求, 请求数据为 xml 的字符串
     *
     * @param url 请求url地址
     * @param xml 请求数据, xml 字符串
     * @return string
     */
    public static String doPostXml(String url, String xml) {
        logger.info("do post request and url[{}]", url);
        return executePost(url, xml, XML);
    }

    private static String executePost(String url, String data, MediaType contentType) {
        RequestBody requestBody = RequestBody.create(contentType, data);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        return execute(request);
    }

    private static String execute(Request request) {
        try (Response response = OK_HTTP_CLIENT.newCall(request).execute()) {
            if (response.isSuccessful()) {
                assert response.body() != null;
                return response.body().string();
            }
        } catch (Exception e) {
            logger.error("okhttp request 出错啦：" + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

    private static ConnectionPool pool() {
        return new ConnectionPool(20, 5L, TimeUnit.MINUTES);
    }

    private static SSLContext createEasySSLContext() {
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, null);
            return context;
        } catch (Exception e) {
            logger.error("createEasySSLContext 出错啦：" + ExceptionUtils.getStackTrace(e));
        }
        return null;
    }

    public static class EasyX509TrustManager implements X509TrustManager {

        private X509TrustManager standardTrustManager = null;

        /**
         * Constructor for EasyX509TrustManager.
         */
        public EasyX509TrustManager(KeyStore keystore) {
            super();
            try {
                TrustManagerFactory factory = TrustManagerFactory.getInstance(TrustManagerFactory
                        .getDefaultAlgorithm());
                factory.init(keystore);
                TrustManager[] trustmanagers = factory.getTrustManagers();
                if (trustmanagers.length == 0) {
                    throw new NoSuchAlgorithmException("no trust manager found");
                }
                this.standardTrustManager = (X509TrustManager) trustmanagers[0];
            } catch (KeyStoreException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        /**
         * @see X509TrustManager#checkClientTrusted(X509Certificate[],
         * String authType)
         */
        @Override
        public void checkClientTrusted(X509Certificate[] certificates, String authType)
                throws CertificateException {
            standardTrustManager.checkClientTrusted(certificates, authType);
        }

        /**
         * @see X509TrustManager#checkServerTrusted(X509Certificate[],
         * String authType)
         */
        @Override
        public void checkServerTrusted(X509Certificate[] certificates, String authType)
                throws CertificateException {
            if ((certificates != null) && (certificates.length == 1)) {
                certificates[0].checkValidity();
            } else {
                standardTrustManager.checkServerTrusted(certificates, authType);
            }
        }

        /**
         * @see X509TrustManager#getAcceptedIssuers()
         */
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return this.standardTrustManager.getAcceptedIssuers();
        }
    }
}
