package com.example.GymGuide;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.cgpacalculator.R;

import java.util.ArrayList;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Arms_Activity extends AppCompatActivity {
ImageView arms_image1;
RecyclerView arms_recyclerview;
    private ArrayList<Integer> Arms_image=new ArrayList<>();
    private ArrayList<String> Arms_Text=new ArrayList<>();
    private ArrayList<String> Arms_Text2=new ArrayList<>();
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arms_);

        arms_image1=findViewById(R.id.arms_image1);
        arms_image1.setImageDrawable(getResources().getDrawable(R.drawable.arms));

        arms_recyclerview=findViewById(R.id.arms_recyclerview);


        arms_recyclerview.setHasFixedSize(true);

        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        arms_recyclerview.setLayoutManager(layoutManager4);
        getData3();
        Arms_Adapter adapter5=new Arms_Adapter(this,Arms_image,Arms_Text,Arms_Text2);
        arms_recyclerview.setAdapter(adapter5);

/*        Toolbar arms_toolbar;
        arms_toolbar=findViewById(R.id.arms_toolbar);
        arms_toolbar.setTitle("Arms Excercise");
        setSupportActionBar(arms_toolbar);*/

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Arms Excercise");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));

    }
    void getData3()
    {
        Arms_image.add(R.drawable.arm1);
        Arms_Text.add("Kettlebell Windmill 1");
        Arms_Text2.add("3 x 15 wraps");

        Arms_image.add(R.drawable.arm2);
        Arms_Text.add("Dumbell Preacher Curl Over Excercise Ball");
        Arms_Text2.add("3 x 15 wraps");

        Arms_image.add(R.drawable.arm3);
        Arms_Text.add("Barbell Incline Reverse Grip Press");
        Arms_Text2.add("3 x 15 wraps");

        Arms_image.add(R.drawable.arm4);
        Arms_Text.add("Kettlebell Windmill 2");
        Arms_Text2.add("3 x 15 wraps");

        Arms_image.add(R.drawable.arm5);
        Arms_Text.add("Single Hand Pull Rope");
        Arms_Text2.add("3 x 15 wraps");
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
