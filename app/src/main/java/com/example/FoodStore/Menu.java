package com.example.FoodStore;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.cgpacalculator.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Menu extends Fragment
{

    GridView gv;
    MenuAdapter adapter;
    ArrayList<ModelData> data;
    DatabaseReference data_ref;
    SearchView sv;
    String filter;

    public Menu() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        filter = getArguments().getString("shop");

        data_ref= FirebaseDatabase.getInstance().getReference("Items");
        gv=v.findViewById(R.id.sp_menu_gv);
        sv=(SearchView)v.findViewById(R.id.menu_sv);
        getData();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String s)
            {
                doSearch(s);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return v;
    }

    public void getData()
    {
        data=new ArrayList<>();
        data_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                    ModelData d=ds.getValue(ModelData.class);
                    if(filter.equals("10") | filter.equals(d.getItem_shop()))
                        data.add(d);
                }

                adapter=new MenuAdapter(getActivity(),data);
                gv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(),"Error Occured",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void doSearch(String s)
    {
        if(s==null)
        {
            adapter=new MenuAdapter(getContext(),data);
            gv.setAdapter(adapter);
            return;
        }
        String userInput=s.toLowerCase();
        ArrayList<ModelData> filterlist=new ArrayList<>();
        for(int i=0;i<data.size();i++)
        {
            String st=data.get(i).getItem_name().toLowerCase();
            if(st.contains(userInput)) {
                filterlist.add(data.get(i));
            }
        }
        adapter=new MenuAdapter(getContext(),filterlist);
        gv.setAdapter(adapter);
    }

}