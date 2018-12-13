package com.example.rajat.smsreading;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>
{
    private Context context;
    private List<SMSData> smsDatas;
    public MyAdapter(Context context, List<SMSData> smsDatas)
    {
        this.context=context;
        this.smsDatas=smsDatas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.smsread,parent,false);
        ViewHolder viewHolder=new ViewHolder(v);
        return viewHolder;  
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        SMSData smsData = smsDatas.get(position);
        holder.textbody.setText(smsData.getBody());
        holder.textAddr.setText(smsData.getAddr());
        holder.textsend.setText("Date Send: "+smsData.getSend_date());
        holder.textrecv.setText("Date Recieved: "+smsData.getRec_date());

    }

    @Override
    public int getItemCount() {
        return smsDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textAddr,textsend,textrecv,textbody;

        public ViewHolder(View itemView)
        {
            super(itemView);
            textAddr=(TextView)itemView.findViewById(R.id.sender);
            textsend=(TextView)itemView.findViewById(R.id.date_send);
            textrecv=(TextView)itemView.findViewById(R.id.date_recieve);
            textbody=(TextView)itemView.findViewById(R.id.textbody);

        }
    }

}

