package com.bwei.jiangbikuan.monthdemo.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.jiangbikuan.monthdemo.R;
import com.bwei.jiangbikuan.monthdemo.ui.view.AddSubtractView;
import com.bwei.jiangbikuan.monthdemo.ui.view.TrapezoidView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AddSubtractView mAsv;
    private TrapezoidView mTv;
    private ViewGroup.MarginLayoutParams layoutParams;
    private int width;
    private int height;
    private int num = 1;
    private int childWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取屏幕的宽高
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        childWidth = width/3;
        height = wm.getDefaultDisplay().getHeight();
        initView();
        initData();


    }

    private void initData() {
        mTv = (TrapezoidView) findViewById(R.id.tv);

        layoutParams = new ViewGroup.MarginLayoutParams(childWidth, 50);
        layoutParams.leftMargin = 5;
        layoutParams.rightMargin = 5;
        layoutParams.topMargin = 5;
        layoutParams.bottomMargin = 5;
        for (int i = 0; i < num; i++) {
            TextView textView = new TextView(this);
            textView.setText(i + 1 + "");
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(Color.BLACK);
            mTv.addView(textView, layoutParams);
        }

        mTv.setOnItemClickListener(new TrapezoidView.OnItemClickListener() {
            @Override
            public void onItemClick(View view) {
                TextView tv = (TextView) view;
                String string = tv.getText().toString();
                Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,ShowDataActivity.class);
                intent.putExtra("page",string);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view) {
                mTv.deleteItem(view);
            }
        });

    }

    private void initView() {
        mAsv = (AddSubtractView) findViewById(R.id.asv);
        mAsv.setmOnAddSubtractListener(new AddSubtractView.OnAddSubtractListener() {
            @Override
            public void onClickAdd(View view) {
                num++;
                TextView textView = mTv.addItem(num,childWidth*2);
                mTv.addView(textView, layoutParams);
            }
        });
    }
}
