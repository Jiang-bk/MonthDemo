package com.bwei.jiangbikuan.monthdemo.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwei.jiangbikuan.monthdemo.R;

public class AddSubtractView extends LinearLayout {

    private TextView tv_num;

    public AddSubtractView(Context context) {
        this(context,null);
    }

    public AddSubtractView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AddSubtractView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View inflate = View.inflate(context, R.layout.add_subtract, this);
        TextView tv_add = (TextView) inflate.findViewById(R.id.add);
        tv_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnAddSubtractListener != null){
                    mOnAddSubtractListener.onClickAdd(v);
                }
            }
        });
    }

    //设置接口
    public interface OnAddSubtractListener{
        void onClickAdd(View view);
    }

    //声明接口
    private OnAddSubtractListener mOnAddSubtractListener;

    //提供方法
    public void setmOnAddSubtractListener(OnAddSubtractListener listener){
        this.mOnAddSubtractListener = listener;
    }

}
