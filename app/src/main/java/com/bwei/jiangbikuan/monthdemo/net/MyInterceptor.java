package com.bwei.jiangbikuan.monthdemo.net;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 自定义拦截器用于封装公共参数
 */
public class MyInterceptor implements Interceptor{
    //声明响应对象
    private Response response;
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取原始的Requset请求
        Request originalRequest = chain.request();
        //获取请求的方法
        String method = originalRequest.method();
        //判断是GET请求还是POST请求
        if("GET".equals(method)){
            HttpUrl httpUrl = originalRequest.url()
                    .newBuilder()
                    .addQueryParameter("source","android")
                    .build();
            //获取添加公共参数之后的requset对象
            Request request = new Request.Builder().url(httpUrl).build();
            //发送拼接完成后的请求
            response = chain.proceed(request);
        }else if("POST".equals(method)){
            RequestBody requestBody = originalRequest.body();
            if(requestBody instanceof FormBody){
                FormBody.Builder builder = new FormBody.Builder();
                FormBody originalFormBody = (FormBody) originalRequest.body();
                for (int i = 0; i < originalFormBody.size(); i++) {
                    builder.add(originalFormBody.name(i),originalFormBody.value(i));
                }
                builder.add("source","android");
                FormBody formBody = builder.build();
                Request request = originalRequest.newBuilder().post(formBody).build();
                response = chain.proceed(request);
            }else{
                response = chain.proceed(originalRequest);
            }
        }
        return response;
    }
}
