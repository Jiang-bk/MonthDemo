package com.bwei.jiangbikuan.monthdemo.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.jiangbikuan.monthdemo.R;
import com.bwei.jiangbikuan.monthdemo.model.RefreshBean;

import java.util.List;

public class MyXrvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final int ONE = 0;
    private final int TWO = 1;

    private Context context;
    private List<RefreshBean.DataBean> list;

    public MyXrvAdapter(Context context,  List<RefreshBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        if(viewType == ONE){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_one,null,false);
            viewHolder = new OneViewHolder(inflate);
        }else if(viewType == TWO){
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_two,null,false);
            viewHolder = new TwoViewHolder(inflate);
        }else{
            viewHolder = null;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        RefreshBean.DataBean dataBean = list.get(position);
        int viewType = getItemViewType(position);
        if(viewType == ONE){
            OneViewHolder oneViewHolder = (OneViewHolder) holder;
            oneViewHolder.title_one.setText(dataBean.getTopic());

            Glide.with(context).load(dataBean.getLbimg().get(0).getSrc()).into(oneViewHolder.image01);
            Glide.with(context).load(dataBean.getLbimg().get(0).getSrc()).into(oneViewHolder.image02);
            Glide.with(context).load(dataBean.getLbimg().get(0).getSrc()).into(oneViewHolder.image03);
            oneViewHolder.time_one.setText(dataBean.getDate()+" "+dataBean.getSource());

            oneViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(mOnItemClickListener != null){
                        mOnItemClickListener.onItemLongListener(position);
                    }
                    return true;
                }
            });
        }else if(viewType == TWO){
            TwoViewHolder twoViewHolder = (TwoViewHolder) holder;
            twoViewHolder.title_two.setText(dataBean.getTopic());
            Glide.with(context).load(dataBean.getLbimg().get(0).getSrc()).into(twoViewHolder.image_two);
            twoViewHolder.time_two.setText(dataBean.getDate()+" "+dataBean.getSource());

            twoViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(mOnItemClickListener != null){
                        mOnItemClickListener.onItemLongListener(position);
                    }
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 3 == 0){
            return TWO;
        }else{
            return ONE;
        }
    }

    class OneViewHolder extends RecyclerView.ViewHolder{
        private final TextView title_one;
        private final ImageView image01;
        private final ImageView image02;
        private final ImageView image03;
        private final TextView time_one;
        public OneViewHolder(View itemView) {
            super(itemView);
            title_one = itemView.findViewById(R.id.title_one);
            image01 = itemView.findViewById(R.id.image01);
            image02 = itemView.findViewById(R.id.image02);
            image03 = itemView.findViewById(R.id.image03);
            time_one = itemView.findViewById(R.id.time_one);

        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder{
        private final ImageView image_two;
        private final TextView title_two;
        private final TextView time_two;
        public TwoViewHolder(View itemView) {
            super(itemView);
            image_two = itemView.findViewById(R.id.image_two);
            title_two = itemView.findViewById(R.id.title_two);
            time_two = itemView.findViewById(R.id.time_two);
        }
    }

    //设置接口
    public interface OnItemClickListener{
        void onItemLongListener(int position);
    }

    private OnItemClickListener mOnItemClickListener;

    //设置方法
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    //删除
    public void deleteItem(int position){
        list.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, list.size()-position);
    }
}
