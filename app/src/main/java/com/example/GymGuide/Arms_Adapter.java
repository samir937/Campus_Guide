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

public class Arms_Adapter extends RecyclerView.Adapter<Arms_Adapter.ViewHolder> {
    private ArrayList<Integer> Arms_image=new ArrayList<>();
    private ArrayList<String> Arms_Text=new ArrayList<>();
    private ArrayList<String> Arms_Text2=new ArrayList<>();
    Context context;
    public Arms_Adapter(Context context,ArrayList<Integer> Arms_Image,ArrayList<String> Arms_Text,ArrayList<String> Arms_Text2){
        this.context=context;
        this.Arms_image=Arms_Image;
        this.Arms_Text=Arms_Text;
        this.Arms_Text2=Arms_Text2;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.arms_custom,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Arms_Adapter.ViewHolder viewHolder, int i) {
        Glide.with(context)
               // .asBitmap()
                .asGif()
                .load(Arms_image.get(i))

                .into(viewHolder.arms_images);

        viewHolder.arms_text.setText(Arms_Text.get(i));
        viewHolder.arms_text2.setText(Arms_Text2.get(i));
    }

    @Override
    public int getItemCount() {
        return Arms_image.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView arms_images;
        TextView arms_text;
        TextView arms_text2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            arms_images=itemView.findViewById(R.id.arms_images);
            arms_text=itemView.findViewById(R.id.arms_text);
            arms_text2=itemView.findViewById(R.id.arms_text2);
        }
    }
}
