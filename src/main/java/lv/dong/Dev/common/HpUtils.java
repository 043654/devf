package lv.dong.Dev.common;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Donglee
 * @version 1.0
 * @description: http工具类
 * @date 2023/10/20 16:42
 */
@Slf4j
public class HpUtils {

    private static final OkHttpClient HC;
    private static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    private static final MediaType plain
            = MediaType.get("text/plain; charset=utf-8");

    static {
        HC = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    private HpUtils() {
    }

    /***
     /**
     * @description:非ssl版get请求
     * @author: DongLee
     */
    @NotNull
    public static String doGet(String url) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("Content-Type", "application/json").build();
        log.info("get请求报文==========" + request);
        try (Response response = HC.newCall(request).execute()) {
            if (response.body() != null) {
                return response.body().string();
            }
        }
        return "快看看，GET请求没好使";
    }

    /***
     /**
     * @description:非ssl版post请求
     * @author: DongLee
     * @return
     */
    @NotNull
    public static String doPost(String body, String url) {
        RequestBody requestBody = RequestBody.create(body, plain);
        Request request = new Request.Builder()
                .post(requestBody)
                .url(url).build();
        log.info("准备请求的请求体" + body);
        log.info("准备请求的请求对象" + request);
        try (Response response = HC.newCall(request).execute()) {
            if (response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "快看看，POST请求没好使";
    }
}
