package com.bwei.jiangbikuan.monthdemo.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.bwei.jiangbikuan.monthdemo.dao.MyDao;
import com.bwei.jiangbikuan.monthdemo.model.RefreshBean;
import com.bwei.jiangbikuan.monthdemo.model.RefreshModelImp;
import com.bwei.jiangbikuan.monthdemo.net.Api;
import com.bwei.jiangbikuan.monthdemo.net.OnNetListener;
import com.bwei.jiangbikuan.monthdemo.ui.view.RefreshView;
import com.bwei.jiangbikuan.monthdemo.utils.NetStateUtils;
import com.google.gson.Gson;

import java.util.List;

public class RefreshpresenterImp implements Refreshpresenter{
    private RefreshView refreshView;
    private final RefreshModelImp refreshModelImp;
    private Context context;
    private MyDao dao;
    public RefreshpresenterImp(RefreshView refreshView, Context context) {
        this.refreshView = refreshView;
        this.context = context;
        refreshModelImp = new RefreshModelImp();
        dao = new MyDao(context);
    }

    @Override
    public void showData(final String page) {
        boolean connect = NetStateUtils.isConnect(context);
        Log.e("JBK",connect+"");
        if(connect){
            refreshModelImp.showData(page, new OnNetListener() {
                @Override
                public void OnSuccess(String result) {

                    String replace = result.replace("null(", "").replace(")", "");
                    dao.insert(Api.REFRESH_URL + "?type=501" + page,replace);
                    RefreshBean refreshBean = new Gson().fromJson(replace, RefreshBean.class);
                    List<RefreshBean.DataBean> data = refreshBean.getData();
                    refreshView.showData(data);
                }

                @Override
                public void OnSuccess(byte[] bytes) {

                }

                @Override
                public void onFailed(Exception e) {

                }
            });
        }else{
            refreshView.showToast("没有网络", Toast.LENGTH_SHORT);
            String select = dao.select(Api.REFRESH_URL + "?type=501" + page);
            RefreshBean refreshBean = new Gson().fromJson(select, RefreshBean.class);
            List<RefreshBean.DataBean> data = refreshBean.getData();
            refreshView.showData(data);
        }

    }

    public void closeView(){
        if(refreshView != null){
            refreshView = null;
        }
    }
}
