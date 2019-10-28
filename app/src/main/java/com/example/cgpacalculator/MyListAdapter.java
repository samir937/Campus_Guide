package com.example.cgpacalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;

class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{

    ArrayList<SubjectDetails>subject;
    Context context;

    public MyListAdapter(Context context,ArrayList<SubjectDetails>subject)
    {
        this.context=context;
        this.subject = subject;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textViews1.setText(subject.get(position).getCourse_code());
        holder.textViews2.setText(String.valueOf(subject.get(position).getCA()));
        holder.textViews3.setText(String.valueOf(subject.get(position).getMTE()));
        holder.textViews4.setText(String.valueOf(subject.get(position).getETE()));
        holder.textViews5.setText(String.valueOf(subject.get(position).getAttendence()));
        holder.textViews6.setText(String.valueOf(subject.get(position).getTotal()));
        holder.textViews7.setText(String.valueOf(subject.get(position).getGrade()));



       /* holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"click on item: "+myListData,Toast.LENGTH_SHORT).show();
            }
        });*/
    }


    @Override
    public int getItemCount() {
        return subject.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViews1,textViews2,textViews3,textViews4,textViews5,textViews6,textViews7;
        public RelativeLayout relativeLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textViews1 = (TextView) itemView.findViewById(R.id.textView1);
            this.textViews2 = (TextView) itemView.findViewById(R.id.textView3);
            this.textViews3 = (TextView) itemView.findViewById(R.id.textView5);
            this.textViews4 = (TextView) itemView.findViewById(R.id.textView7);
            this.textViews5 = (TextView) itemView.findViewById(R.id.textView9);
            this.textViews6 = (TextView) itemView.findViewById(R.id.textView11);
            this.textViews7 = (TextView) itemView.findViewById(R.id.textView13);

        }
    }
}