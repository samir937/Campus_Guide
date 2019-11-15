package com.example.FoodStore;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cgpacalculator.R;
import com.razorpay.Checkout;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Cart extends Fragment implements View.OnClickListener
{

    RecyclerView rv1;
    CartAdapter adapter;
    ArrayList<ModelOrder> item;


    Button b1;

    public Cart() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_cart, container, false);
        Checkout.preload(getContext());
        rv1=v.findViewById(R.id.cart_rv);
        b1=v.findViewById(R.id.cart_b1);
        b1.setOnClickListener(this);
        return v;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        item=SingletonCart.getInstance().arr;     // data from singleton Modelcart
        if(item.size()==0)
            b1.setVisibility(View.INVISIBLE);
        else
            b1.setVisibility(View.VISIBLE);
        rv1.setHasFixedSize(true);
        rv1.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new CartAdapter(getActivity(),item);
        rv1.setAdapter(adapter);
    }

    public void onClick(View v)
    {
        if(v==b1)
        {
            HaveAddress();
        }
    }

    public void HaveAddress()
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
        View v=getLayoutInflater().inflate(R.layout.information,null);
        alert.setTitle("Delievery Information");
        final EditText name=v.findViewById(R.id.inf_e1);
        final EditText phone=v.findViewById(R.id.inf_e2);
        final EditText address=v.findViewById(R.id.inf_e3);
        final Button b1=v.findViewById(R.id.inf_b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Payment p=new Payment(name.getText().toString(),phone.getText().toString(),address.getText().toString());
                p.startPayment(getActivity());
            }
        });
        alert.setView(v);
        alert.show();
    }
}
