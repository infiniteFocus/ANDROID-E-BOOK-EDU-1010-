package com.infinitefocus.edu1010.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.infinitefocus.edu1010.Interface.CustomItemClickListener;
import com.infinitefocus.edu1010.R;

import java.util.List;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.mViewHolder>{

    private Context mContext;
    private List<String> mTitleList;
    private CustomItemClickListener clickListener;

    public TitleAdapter(Context mContext, List<String> mTitleList, CustomItemClickListener clickListener) {
        this.mContext = mContext;
        this.mTitleList = mTitleList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public mViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.custom_list,parent,false);
        final mViewHolder viewHolder = new mViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickListener.onItemClick(view,viewHolder.getPosition());

            }
        });
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull mViewHolder holder, int position) {

        holder.mTitle.setText(mTitleList.get(position).replace("_"," "));

    }

    @Override
    public int getItemCount() {
        return mTitleList.size();
    }

    class mViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.page);

        }
    }
}
