package com.bwei.jiangbikuan.monthdemo.net;

import android.os.Handler;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpUtils {

    private static OkhttpUtils instener;
    private OkHttpClient okHttpClient;
    private static Handler handler;

    private OkhttpUtils() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                //.addInterceptor(new MyInterceptor())
                .addInterceptor(logging)
                .build();
        handler = new Handler();
    }

    public static OkhttpUtils getInstener() {
        if (instener == null) {
            instener = new OkhttpUtils();
        }
        return instener;
    }

    //处理请求网络成功的方法,返回的结果是Json字符串
    private static void onSuccessJsonStringMethod(final String jsonValue ,final OnNetListener callBack){
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (callBack !=null){
                    callBack.OnSuccess(jsonValue);
                }
            }
        });
    }

    //处理请求网络错误的方法
    private static void onFailedJsonStringMethod(final Exception e, final OnNetListener onNetListener){
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(onNetListener != null){
                    onNetListener.onFailed(e);
                }
            }
        });
    }

    /**
     * 封装GET方法
     * @param url 网络路径
     * @param onNetListener 接口对象
     */
    public void doGet(String url, final OnNetListener onNetListener) {
        //创建Request
        Request request = new Request.Builder().url(url).build();
        //发送请求
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                onFailedJsonStringMethod(e,onNetListener);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string= response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnSuccess(string);
                    }
                });
            }
        });
    }

    /**
     * 封装post方法
     * @param url 网络路径
     * @param params 路径添加的参数
     * @param onNetListener 接口
     */
    public void doPost(String url, Map<String, String> params, final OnNetListener onNetListener) {
        //创建formBody
        FormBody.Builder builder = new FormBody.Builder();
        //添加参数
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        FormBody formBody = builder.build();
        //创建Request
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        //请求网络
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                onFailedJsonStringMethod(e,onNetListener);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                onSuccessJsonStringMethod(string,onNetListener);
            }
        });
    }

    /**
     *
     * 封装上传文件
     * @param url   网络地址
     * @param params    参数集合
     * @param fileNmae  文件名
     * @param file  文件
     * @param onNetListener 接口
     */
    public void uploadFild(String url, Map<String, String> params, String fileNmae, File file, final OnNetListener onNetListener){
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        //上传参数
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.addFormDataPart(entry.getKey(), entry.getValue());
        }
        builder.addFormDataPart("file", fileNmae, RequestBody.create(MediaType.parse("application/octet-stream"),file));
        MultipartBody multipartBody = builder.build();

        Request request = new Request.Builder().url(url).post(multipartBody).build();

        //发送请求
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                onFailedJsonStringMethod(e,onNetListener);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
               onSuccessJsonStringMethod(string,onNetListener);
            }
        });
    }

}
