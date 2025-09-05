package com.example.shoppingdemoapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingdemoapplication.R;
import com.example.shoppingdemoapplication.model.Produce;

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {

    private List<Produce> produceList;
    private LayoutInflater layoutInflater;
    private Context mContext;

    public myAdapter(Context context,List<Produce> produceList){
        this.mContext=context;
        this.produceList=produceList;
        layoutInflater=LayoutInflater.from(mContext);
    }

    @Override
    public int getItemCount() {
        return produceList.size();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.list_item_layout,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {   //绑定ViewHolder,传数据
        Produce produce=produceList.get(position);
        holder.mTvTitle.setText(produce.getTitle());
        holder.mTvContent.setText(produce.getContent());
        holder.mTvPrice.setText(String.valueOf(produce.getPrice()));
        holder.mTvImage.setImageResource(produce.getImageUrl());
       /** holder.rlContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"你点击了"+position,Toast.LENGTH_SHORT).show();
            }
        });**/

        //点击事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int realPosition = holder.getAdapterPosition();
                if(mOnItemClickListener!=null){
                    //Adapter 通过接口回调通知外部（如 Activity/Fragment）用户点击了某个列表项
                    mOnItemClickListener.onItemClick(produce,realPosition);
                }
            }
        });
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mTvTitle;
        TextView mTvContent;
        TextView mTvPrice;
        ImageView mTvImage;

        TextView mTvDetail;

        RelativeLayout rlContainer;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mTvImage=itemView.findViewById(R.id.iv_img);
            this.mTvTitle=itemView.findViewById(R.id.tv_title);
            this.mTvPrice=itemView.findViewById(R.id.tv_price);
            this.mTvContent=itemView.findViewById(R.id.tv_content);
            this.rlContainer=itemView.findViewById(R.id.rl_item_container);

        }
    }


    private  onItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        mOnItemClickListener=onItemClickListener;
    }


    public interface onItemClickListener{
        void onItemClick(Produce produce,int position);
    }
}
