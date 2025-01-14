package com.yaoxiang.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.net.ssl.*;
import java.security.cert.X509Certificate;
import feign.Client;
/**
 * @author maxiaoguang
 */
@Configuration
public class FeignClientConfig {

    @Bean
    public OkHttpClient unsafeOkHttpClient() {
        try {
            /**
             * 创建一个不验证证书链的信任管理器
              */
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] chain, String authType) {}

                        @Override
                        public void checkServerTrusted(X509Certificate[] chain, String authType) {}

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[]{};
                        }
                    }
            };

            /**
             * 安装所有信任的 SSL 上下文
              */

            final SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            /**
             * 创建允许所有主机名的主机名验证器
             */
            final HostnameVerifier allHostsValid = (hostname, session) -> true;

            /**
             * 使用上述 SSL 上下文和主机名验证器创建 OkHttp 客户端
              */
            OkHttpClient client = new OkHttpClient.Builder()
                    .sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0])
                    .hostnameVerifier(allHostsValid)
                    .build();

            return client;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public Client feignClient(OkHttpClient client) {
        return new feign.okhttp.OkHttpClient(client);
    }

}