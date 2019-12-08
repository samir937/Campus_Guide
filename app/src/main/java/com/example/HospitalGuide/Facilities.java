package com.example.HospitalGuide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cgpacalculator.R;

public class Facilities extends AppCompatActivity {


        ListView listView;
        String[] fact;
        ArrayAdapter<String> adapter;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_facilities);
            ActionBar actionBar=getSupportActionBar();
            if (actionBar!=null){
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
            actionBar.setTitle("Facilities");
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));


            fact=getResources().getStringArray(R.array.array_facts);
            listView=findViewById(R.id.listView);
            adapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,fact);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent=new Intent(Facilities.this,FactDetail.class);
                    intent.putExtra("num",i);
                    startActivity(intent);
                }
            });
        }
        @Override
        public boolean onSupportNavigateUp() {
            onBackPressed();
            return super.onSupportNavigateUp();
        }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
