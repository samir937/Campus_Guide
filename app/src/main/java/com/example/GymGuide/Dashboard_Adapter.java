package com.example.GymGuide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.cgpacalculator.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Dashboard_Adapter extends RecyclerView.Adapter<Dashboard_Adapter.ViewHolder> {
    Context context2;


    public Dashboard_Adapter(Context context2, ArrayList<Integer> recipeImage1, ArrayList<String> recipeprice1) {
        this.context2 = context2;
        // this.recipeName1 = recipeName1;
        this.recipeImage1 = recipeImage1;
        this.recipeprice1 = recipeprice1;
    }

    // private ArrayList<String> recipeName1=new ArrayList<>();
    private ArrayList<Integer> recipeImage1=new ArrayList<>();
    private ArrayList<String> recipeprice1=new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dashboard_custom,viewGroup,false);
        Dashboard_Adapter.ViewHolder viewHolder=new Dashboard_Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Glide.with(context2)
                .asBitmap()
                .load(recipeImage1.get(i))
                .into(viewHolder.image);
        // viewHolder.image_breakfast.setImageDrawable(context.getResources().getDrawble(Product.getImage(),null));
        //    viewHolder.tv_south.setText(recipeName1.get(i));
        viewHolder.tv.setText(recipeprice1.get(i));

        viewHolder.dashboard_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (i)
                {
                    case 0:

                        context2.startActivity(new Intent(context2,Workout_Activity.class));
                        break;

                    case 1:
                        context2.startActivity(new Intent(context2,Protien_Activity.class));
                        break;

                    case 2:
                        context2.startActivity(new Intent(context2,Membership_Activity.class));
                        break;

                    case 3:
                        context2.startActivity(new Intent(context2,Diet_Activity.class));
                        break;

                    case 4:
                        context2.startActivity(new Intent(context2,CaloryMeter_Activity.class));
                        break;
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return recipeImage1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView tv;
        CardView dashboard_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            tv=itemView.findViewById(R.id.tv);
            dashboard_card=itemView.findViewById(R.id.dashboard_card);
        }
    }
}
