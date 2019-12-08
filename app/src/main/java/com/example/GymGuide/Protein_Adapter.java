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

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Protein_Adapter extends RecyclerView.Adapter<Protein_Adapter.ViewHolder> {
  //  private ArrayList<Integer> Abs_image=new ArrayList<>();
  //  private ArrayList<String> Abs_Text=new ArrayList<>();
  //  private ArrayList<String> Abs_Text2=new ArrayList<>();

    int[] protein_img;
    String pn[];
    String[] protein_weiht_array;
    String[] descrption_protien;
    Context context;
    public Protein_Adapter(Context context,int[] protein_img, String pn[],String[] protein_weiht_array,String[] descrption_protien){
        this.context=context;
        this.protein_img=protein_img;
        this.pn=pn;
        this.protein_weiht_array=protein_weiht_array;
        this.descrption_protien=descrption_protien;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.protein_custom,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Protein_Adapter.ViewHolder viewHolder, final int i) {
        Glide.with(context)
                // .asBitmap()
                .asBitmap()
                .load(protein_img[i])

                .into(viewHolder.protein_images);

        viewHolder.protein_name.setText(pn[i]);
        viewHolder.shoulder_weight.setText(protein_weiht_array[i]);

        viewHolder.protein_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Single_Protein_Activity.class);
                intent.putExtra("protein_image", protein_img[i]);
                intent.putExtra("protein_name", pn[i]);

                intent.putExtra("protein_weight", protein_weiht_array[i]);
                intent.putExtra("protein_description", descrption_protien[i]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return protein_img.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView protein_images;
        TextView protein_name;
        TextView shoulder_weight;
        CardView protein_card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            protein_images=itemView.findViewById(R.id.protein_images);
            protein_name=itemView.findViewById(R.id.protein_name);
            shoulder_weight=itemView.findViewById(R.id.protein_weight);
            protein_card=itemView.findViewById(R.id.protein_card);
        }
    }
}