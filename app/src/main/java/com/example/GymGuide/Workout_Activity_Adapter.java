package com.example.GymGuide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.cgpacalculator.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Workout_Activity_Adapter extends RecyclerView.Adapter<Workout_Activity_Adapter.ViewHolder> {
    private ArrayList<Integer> ExcerciseImage1=new ArrayList<>();
    Context context;
public Workout_Activity_Adapter(Context context,ArrayList<Integer> ExcerciseImage1){
        this.ExcerciseImage1=ExcerciseImage1;
        this.context=context;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.workout_activity_custom,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Workout_Activity_Adapter.ViewHolder viewHolder, final int i) {
        Glide.with(context)
                .asBitmap()
                .load(ExcerciseImage1.get(i))
                .into(viewHolder.workout_images);
        viewHolder.workout_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "Arms", Toast.LENGTH_SHORT).show();

                switch (i)
                {

                    case 0:
                        context.startActivity(new Intent(context,Abs_Activity.class));
                        break;

                    case 1:
                        context.startActivity(new Intent(context,Arms_Activity.class));
                        break;

                    case 2:
                        context.startActivity(new Intent(context,Chest_Activity.class));
                        break;

                    case 3:
                        context.startActivity(new Intent(context,Shoulder_Activity.class));
                        break;

                    case 4:
                        context.startActivity(new Intent(context,Leg_Activity.class));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return ExcerciseImage1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
    ImageView workout_images;
    CardView workout_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            workout_images=itemView.findViewById(R.id.workout_images);
            workout_card=itemView.findViewById(R.id.workout_card);
        }
    }

}
