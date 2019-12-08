package com.example.GymGuide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cgpacalculator.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Membership_Adapter extends RecyclerView.Adapter<Membership_Adapter.ViewHolder> {
    private ArrayList<Integer> membership_facility_img=new ArrayList<>();
    private ArrayList<String> membership_facility_text=new ArrayList<>();
    Context context;
    public Membership_Adapter(Context context,ArrayList<Integer> membership_facility_img,ArrayList<String> membership_facility_text){
        this.context=context;
        this.membership_facility_img=membership_facility_img;
        this.membership_facility_text=membership_facility_text;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.membership_custom,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Membership_Adapter.ViewHolder viewHolder, int i) {
        Glide.with(context)
                // .asBitmap()
                .asBitmap()
                .load(membership_facility_img.get(i))

                .into(viewHolder.membership_facility_image1);

        viewHolder.membership_facility_text1.setText(membership_facility_text.get(i));
    }

    @Override
    public int getItemCount() {
        return membership_facility_img.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView membership_facility_image1;
        TextView membership_facility_text1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            membership_facility_image1=itemView.findViewById(R.id.membership_facility_image1);
            membership_facility_text1=itemView.findViewById(R.id.membership_facility_text1);
        }
    }
}