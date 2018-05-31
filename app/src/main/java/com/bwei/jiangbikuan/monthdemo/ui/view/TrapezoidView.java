package com.bwei.jiangbikuan.monthdemo.ui.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

public class TrapezoidView extends ViewGroup {

    private View childAt;
    private int startWidth;
    private int startHeight;
    //控件的宽度
    private int width;

    public TrapezoidView(Context context) {
        this(context, null);
    }

    public TrapezoidView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TrapezoidView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        width = this.getWidth();

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        startWidth = 0;
        startHeight = 0;
        //获取屏幕的宽度
        int width = getWidth();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            childAt = getChildAt(i);
            if (i % 3 == 0) {
                childAt.setBackgroundColor(Color.RED);
            }
            if (i % 3 == 1) {
                childAt.setBackgroundColor(Color.GREEN);
            }
            if (i % 3 == 2) {
                childAt.setBackgroundColor(Color.BLUE);
            }
            childAt.layout(startWidth, startHeight, startWidth + childAt.getMeasuredWidth(), startHeight + childAt.getMeasuredHeight());
            startWidth += childAt.getMeasuredWidth();
            startHeight += childAt.getMeasuredHeight();
            if (startWidth >= width) {
                startWidth = 0;
            }
        }
        childAt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onItemClick(v);
                }
            }
        });
        childAt.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mOnItemClickListener != null){
                    mOnItemClickListener.onItemLongClick(v);
                }
                return true;
            }
        });
    }

    //添加条目
    public TextView addItem(int num,int childWith) {
        TextView textView = new TextView(getContext());
        textView.setText(num +"");
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        setAnim(textView,childWith);
        return textView;
    }

    private void setAnim(TextView textView,int childWith) {
        ObjectAnimator translationX = ObjectAnimator.ofFloat(textView, "translationX", new float[]{-startWidth,0});
        ObjectAnimator translationY = ObjectAnimator.ofFloat(textView, "translationY", new float[]{-startHeight,0});
        ObjectAnimator alpha = ObjectAnimator.ofFloat(textView, "alpha", new float[]{0f, 1f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(translationX,translationY, alpha);
        animatorSet.setDuration(2000);
        animatorSet.start();

    }

    //删除条目
    public void deleteItem(View view) {
        removeView(view);
    }

    public interface OnItemClickListener{
        void onItemClick(View view);
        void onItemLongClick(View view);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

}
