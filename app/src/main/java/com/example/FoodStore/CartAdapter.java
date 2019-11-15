package com.example.FoodStore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cgpacalculator.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>
{

    private final Context ct;
    private final ArrayList<ModelOrder> item;

    public CartAdapter(Context ct, ArrayList<ModelOrder> item)
    {
        this.ct = ct;
        this.item=item;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater lf = LayoutInflater.from(ct);
        View v = lf.inflate(R.layout.cartitem , viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        viewHolder.t1.setText(item.get(i).getItem_name());
        viewHolder.t2.setText(item.get(i).getItem_shop());
        viewHolder.t3.setText(item.get(i).getItem_price());

        Picasso.get().load(item.get(i).getItem_url()).fit().centerCrop().into(viewHolder.i1);

        final int index=i;
        viewHolder.i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no= Integer.parseInt(viewHolder.e1.getText().toString())+1;
                if(no<10)
                {
                    viewHolder.e1.setText(""+no);
                    SingletonCart.getInstance().arr.get(index).setItem_quantity(""+no);
                }

            }
        });
        viewHolder.i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int no= Integer.parseInt(viewHolder.e1.getText().toString())-1;
                if(no>0) {
                    viewHolder.e1.setText("" + no);
                    SingletonCart.getInstance().arr.get(index).setItem_quantity(""+no);
                }
            }
        });

        final int pos=i;
        viewHolder.i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                SingletonCart ob=SingletonCart.getInstance();
                ob.arr.remove(pos);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1, t2, t3;
        ImageView i1,i4;
        ImageButton i2,i3;
        TextView e1;        // it was edittext before

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.cart_t1);
            t2 = itemView.findViewById(R.id.cart_t2);
            t3 = itemView.findViewById(R.id.cart_t3);
            i2=  itemView.findViewById(R.id.cart_i2);
            i3=  itemView.findViewById(R.id.cart_i3);
            e1 = itemView.findViewById(R.id.cart_e1);
            i4 = itemView.findViewById(R.id.cart_i4);

            i1=   itemView.findViewById(R.id.cart_i1);
        }
    }
}