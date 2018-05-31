package com.bwei.jiangbikuan.monthdemo.ui.view;

import com.bwei.jiangbikuan.monthdemo.model.RefreshBean;

import java.util.List;

public interface RefreshView {
    void showData(List<RefreshBean.DataBean> data);

    void showToast(String str,int length);
}
