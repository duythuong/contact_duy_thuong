package com.example.duynguyen.contact;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class custom_list extends RecyclerView.Adapter<custom_list.ViewHolder>{
    private ArrayList<doituong> mContacts;
    private Context mContext;
    private LayoutInflater mInflater;
    Intent intent;
    public custom_list(ArrayList<doituong> mContacts, Context mContext) {
        this.mContacts = mContacts;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.custom_list, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(custom_list.ViewHolder holder, int i) {
        doituong doituong = mContacts.get(i);
        holder.tvFullname.setText(doituong.getFilsname());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvFullname;
        RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            tvFullname = (TextView) itemView.findViewById(R.id.text);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.click);
            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            intent = new Intent(mContext,giao_dien.class);
            intent.putExtra("id",tvFullname.getText().toString());
            intent.putExtra("boolean",true);
            mContext.startActivity(intent);
            System.out.println(tvFullname.getText());
                }
            });
        }
    }
}
