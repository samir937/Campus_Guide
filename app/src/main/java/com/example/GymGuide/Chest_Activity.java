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

public class Chest_Activity extends AppCompatActivity {
    ImageView chest_image1;
    RecyclerView chest_recyclerview;
    private ArrayList<Integer> Abs_image=new ArrayList<>();
    private ArrayList<String> Abs_Text=new ArrayList<>();
    private ArrayList<String> Abs_Text2=new ArrayList<>();
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_);

        chest_image1=findViewById(R.id.chest_image1);
        chest_image1.setImageDrawable(getResources().getDrawable(R.drawable.chest));
        // abs_image1.setImageResource(R.drawable.abs);
        chest_recyclerview=findViewById(R.id.chest_recyclerview);


        chest_recyclerview.setHasFixedSize(true);

        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        chest_recyclerview.setLayoutManager(layoutManager4);
        getData3();
        Abs_Adapter adapter5=new Abs_Adapter(this,Abs_image,Abs_Text,Abs_Text2);
        chest_recyclerview.setAdapter(adapter5);

      /*  Toolbar chest_toolbar;
        chest_toolbar=findViewById(R.id.chest_toolbar);
        chest_toolbar.setTitle("Chest Excercise");
        setSupportActionBar(chest_toolbar);*/

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Chest Excercise");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));

    }
    void getData3()
    {
        Abs_image.add(R.drawable.chest1);
        Abs_Text.add("Barbell Decline Pullover");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.chest2);
        Abs_Text.add("Bench Press");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.chest3);
        Abs_Text.add("Dumbbell Lying Pullover On Excercise Ball");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.chest4);
        Abs_Text.add("Dumbbell Pullover");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.chest5);
        Abs_Text.add("Cable Standing Pulldown");
        Abs_Text2.add("3 x 15 wraps");
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
