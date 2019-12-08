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

public class Leg_Adapter extends RecyclerView.Adapter<Leg_Adapter.ViewHolder> {
    private ArrayList<Integer> Abs_image=new ArrayList<>();
    private ArrayList<String> Abs_Text=new ArrayList<>();
    private ArrayList<String> Abs_Text2=new ArrayList<>();
    Context context;
    public Leg_Adapter(Context context,ArrayList<Integer> Abs_Image,ArrayList<String> Abs_Text,ArrayList<String> Abs_Text2){
        this.context=context;
        this.Abs_image=Abs_Image;
        this.Abs_Text=Abs_Text;
        this.Abs_Text2=Abs_Text2;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.leg_custom,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Leg_Adapter.ViewHolder viewHolder, int i) {
        Glide.with(context)
                // .asBitmap()
                .asGif()
                .load(Abs_image.get(i))

                .into(viewHolder.leg_images);

        viewHolder.leg_text.setText(Abs_Text.get(i));
        viewHolder.leg_text2.setText(Abs_Text2.get(i));
    }

    @Override
    public int getItemCount() {
        return Abs_image.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView leg_images;
        TextView leg_text;
        TextView leg_text2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            leg_images=itemView.findViewById(R.id.leg_images);
            leg_text=itemView.findViewById(R.id.leg_text);
            leg_text2=itemView.findViewById(R.id.leg_text2);
        }
    }
}
