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

public class Chest_Adapter extends RecyclerView.Adapter<Chest_Adapter.ViewHolder> {
    private ArrayList<Integer> Abs_image=new ArrayList<>();
    private ArrayList<String> Abs_Text=new ArrayList<>();
    private ArrayList<String> Abs_Text2=new ArrayList<>();
    Context context;
    public Chest_Adapter(Context context,ArrayList<Integer> Abs_Image,ArrayList<String> Abs_Text,ArrayList<String> Abs_Text2){
        this.context=context;
        this.Abs_image=Abs_Image;
        this.Abs_Text=Abs_Text;
        this.Abs_Text2=Abs_Text2;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chest_custom,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Chest_Adapter.ViewHolder viewHolder, int i) {
        Glide.with(context)
                // .asBitmap()
                .asGif()
                .load(Abs_image.get(i))

                .into(viewHolder.chest_images);

        viewHolder.chest_text.setText(Abs_Text.get(i));
        viewHolder.chest_text2.setText(Abs_Text2.get(i));
    }

    @Override
    public int getItemCount() {
        return Abs_image.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView chest_images;
        TextView chest_text;
        TextView chest_text2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            chest_images=itemView.findViewById(R.id.chest_images);
            chest_text=itemView.findViewById(R.id.chest_text);
            chest_text2=itemView.findViewById(R.id.chest_text2);
        }
    }
}
