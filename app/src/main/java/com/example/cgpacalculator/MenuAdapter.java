package com.example.cgpacalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter
{
    ArrayList<ModelData> list_data;
    private Context ct;

    public MenuAdapter(Context ct, ArrayList<ModelData> data)
    {
        this.ct=ct;
        this.list_data=data;
    }
    @Override
    public int getCount() {
        return list_data.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.griditem, null);
        TextView t1=convertView.findViewById(R.id.sp_grid_t1);
        TextView t2=convertView.findViewById(R.id.sp_grid_t2);
        ImageView i1=convertView.findViewById(R.id.sp_grid_i1);

        final ModelData data=list_data.get(position);
        t1.setText(data.getItem_name());
        t2.setText("\u20B9"+" "+data.getItem_price());
        Picasso.with(ct).load(data.getItem_url()).fit().centerCrop().into(i1);

        ImageView i2=convertView.findViewById(R.id.sp_grid_i2);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                ModelOrder ob1=new ModelOrder(data.getItem_name(),data.getItem_price()
                ,"0",data.getItem_shop(),data.getItem_url(),data.getItem_owner(),"0","0","0");
                SingletonCart.getInstance().arr.add(ob1);

                Toast.makeText(v.getContext(),"Successfully Added", Toast.LENGTH_LONG).show();

            }
        });
        return convertView;
    }
}