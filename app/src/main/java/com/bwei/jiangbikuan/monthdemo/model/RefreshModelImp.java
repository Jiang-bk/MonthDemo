package com.bwei.jiangbikuan.monthdemo.model;

import android.util.Log;

import com.bwei.jiangbikuan.monthdemo.dao.MyDao;
import com.bwei.jiangbikuan.monthdemo.net.Api;
import com.bwei.jiangbikuan.monthdemo.net.OkhttpUtils;
import com.bwei.jiangbikuan.monthdemo.net.OnNetListener;
import com.bwei.jiangbikuan.monthdemo.utils.NetStateUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class RefreshModelImp implements RefreshModel{
    @Override
    public void showData(String page, OnNetListener onNetListener) {

        OkhttpUtils.getInstener().doGet(Api.REFRESH_URL+"?type=50"+page,onNetListener);

    }
}
