package com.bwei.jiangbikuan.monthdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetStateUtils {
    // 判断是否有网络
    public static boolean isConnect(Context context){
        boolean flag = true;
        // 得到管理器对象
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // 得到网络信息类对象
        NetworkInfo network = manager.getActiveNetworkInfo();
        // 判断有无对象
        if (network != null && network.isConnected()){
            flag = true;
        }else {
            flag = false;
        }
        return flag;
    }

}
