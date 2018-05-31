package com.bwei.jiangbikuan.monthdemo.model;

import com.bwei.jiangbikuan.monthdemo.net.OnNetListener;

public interface RefreshModel {
    void showData(String page, OnNetListener onNetListener);
}
