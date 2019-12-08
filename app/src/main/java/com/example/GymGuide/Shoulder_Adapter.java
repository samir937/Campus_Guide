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



public class Shoulder_Adapter extends RecyclerView.Adapter<Shoulder_Adapter.ViewHolder> {
    private ArrayList<Integer> Abs_image=new ArrayList<>();
    private ArrayList<String> Abs_Text=new ArrayList<>();
    private ArrayList<String> Abs_Text2=new ArrayList<>();
    Context context;
    public Shoulder_Adapter(Context context,ArrayList<Integer> Abs_Image,ArrayList<String> Abs_Text,ArrayList<String> Abs_Text2){
        this.context=context;
        this.Abs_image=Abs_Image;
        this.Abs_Text=Abs_Text;
        this.Abs_Text2=Abs_Text2;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shoulder_custom,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Shoulder_Adapter.ViewHolder viewHolder, int i) {
        Glide.with(context)
                // .asBitmap()
                .asGif()
                .load(Abs_image.get(i))

                .into(viewHolder.shoulder_images);

        viewHolder.shoulder_text.setText(Abs_Text.get(i));
        viewHolder.shoulder_text2.setText(Abs_Text2.get(i));
    }

    @Override
    public int getItemCount() {
        return Abs_image.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView shoulder_images;
        TextView shoulder_text;
        TextView shoulder_text2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            shoulder_images=itemView.findViewById(R.id.shoulder_images);
            shoulder_text=itemView.findViewById(R.id.shoulder_text);
            shoulder_text2=itemView.findViewById(R.id.shoulder_text2);
        }
    }
}
