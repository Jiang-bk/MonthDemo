package com.bwei.jiangbikuan.monthdemo.net;

public interface OnNetListener {
    void OnSuccess(String result);

    void OnSuccess(byte[] bytes);

    void onFailed(Exception e);
}
