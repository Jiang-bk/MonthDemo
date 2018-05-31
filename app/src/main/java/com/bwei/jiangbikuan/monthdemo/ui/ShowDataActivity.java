package com.bwei.jiangbikuan.monthdemo.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import com.bwei.jiangbikuan.monthdemo.R;
import com.bwei.jiangbikuan.monthdemo.dao.MyDao;
import com.bwei.jiangbikuan.monthdemo.model.RefreshBean;
import com.bwei.jiangbikuan.monthdemo.presenter.RefreshpresenterImp;
import com.bwei.jiangbikuan.monthdemo.ui.view.RefreshView;
import com.bwei.jiangbikuan.monthdemo.utils.NetStateUtils;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShowDataActivity extends AppCompatActivity implements RefreshView {
    private RefreshpresenterImp refreshpresenterImp;
    private XRecyclerView mXrv;
    private String page;
    private MyXrvAdapter myXrvAdapter;
    private List<List<RefreshBean.DataBean>> listAll = new ArrayList();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        initView();
        Intent intent = getIntent();
        page = intent.getStringExtra("page");
        int num = Integer.parseInt(page);
        Log.e("JBK", page);
        if(num < 10){
            page = "0"+ page;
        }
        refreshpresenterImp = new RefreshpresenterImp(this,ShowDataActivity.this);
        refreshpresenterImp.showData(page);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        refreshpresenterImp.closeView();
    }

    @Override
    public void showData(List<RefreshBean.DataBean> data) {
        listAll.add(data);
        //适配器
        myXrvAdapter = new MyXrvAdapter(ShowDataActivity.this, data);
        mXrv.setAdapter(myXrvAdapter);
        myXrvAdapter.setOnItemClickListener(new MyXrvAdapter.OnItemClickListener() {
            @Override
            public void onItemLongListener(int position) {
                //弹出对话框
                showAlertDialog(position);

            }
        });
    }

    private void showAlertDialog(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示：");
        builder.setMessage("你确定要删除吗？");
        builder.setCancelable(false);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                myXrvAdapter.deleteItem(position);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showToast(String str, int length) {
        Toast.makeText(this, str, length).show();
    }

    private void initView() {
        mXrv = (XRecyclerView) findViewById(R.id.xrv);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mXrv.setLayoutManager(linearLayoutManager);
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshpresenterImp.showData(page);
                mXrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                int num = Integer.parseInt(page);
                num++;
                Log.e("JBK","加载更多"+num+"");
                if(num < 10){
                    page = "0"+ String.valueOf(num);
                    refreshpresenterImp.showData( page);
                }
                refreshpresenterImp.showData(String.valueOf(num));
                mXrv.loadMoreComplete();
            }
        });
    }
}
