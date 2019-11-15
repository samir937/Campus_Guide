package com.example.FoodStore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cgpacalculator.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FoodActivity extends AppCompatActivity {
        Spinner sp;
        List<String> sname;
        Button b1,b2;
        Set<String> ht;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            b1=findViewById(R.id.main_continue);
            b2=findViewById(R.id.main_shopname);
        }

        @Override
        protected void onResume()
        {
            super.onResume();
            getShopName();
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it=new Intent(FoodActivity.this,FoodHomeActivity.class);
                    it.putExtra("shop","10");
                    startActivity(it);
                }
            });

            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog();
                }
            });
        }

        public void showDialog()
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(FoodActivity.this);
            builder.setTitle("Select shop ");

            ListView lv=new ListView(getApplicationContext());
            ArrayAdapter<String> ad=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,sname);
            lv.setAdapter(ad);

            builder.setCancelable(true);
            builder.setView(lv);
            builder.create().show();

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent it=new Intent(FoodActivity.this,FoodHomeActivity.class);
                    it.putExtra("shop",sname.get(position));
                    startActivity(it);
                }
            });
        }

        public void getShopName()
        {
            ht=new HashSet<>();
            sname=new ArrayList<>();

            DatabaseReference data_ref= FirebaseDatabase.getInstance().getReference("Items");
            data_ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot ds: dataSnapshot.getChildren())
                    {
                        ModelData d=ds.getValue(ModelData.class);
                        System.out.println(d.getItem_shop());
                        sname.add(d.getItem_shop());
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(getApplicationContext(),"Error Occured",Toast.LENGTH_LONG).show();
                }
            });

            for(String s:ht)
            {
                sname.add(s);
                System.out.println(s);
            }
        }

    }