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

public class Leg_Activity extends AppCompatActivity {
    ImageView leg_image1;
    RecyclerView leg_recyclerview;
    private ArrayList<Integer> Abs_image=new ArrayList<>();
    private ArrayList<String> Abs_Text=new ArrayList<>();
    private ArrayList<String> Abs_Text2=new ArrayList<>();
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg_);

        leg_image1=findViewById(R.id.leg_image1);
        leg_image1.setImageDrawable(getResources().getDrawable(R.drawable.legs));
        // abs_image1.setImageResource(R.drawable.abs);
        leg_recyclerview=findViewById(R.id.leg_recyclerview);


        leg_recyclerview.setHasFixedSize(true);

        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        leg_recyclerview.setLayoutManager(layoutManager4);
        getData3();
        Abs_Adapter adapter5=new Abs_Adapter(this,Abs_image,Abs_Text,Abs_Text2);
        leg_recyclerview.setAdapter(adapter5);

       /* Toolbar leg_toolbar;
        leg_toolbar=findViewById(R.id.leg_toolbar);
        leg_toolbar.setTitle("Leg Excercise");
        setSupportActionBar(leg_toolbar);*/

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Leg Excercise");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));

    }
    void getData3()
    {
        Abs_image.add(R.drawable.leg1);
        Abs_Text.add("Front Squat");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.leg2);
        Abs_Text.add("Seated Calf Raise");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.leg3);
        Abs_Text.add("Assisted Single Leg Press");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.leg4);
        Abs_Text.add("Lever Leg Extension");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.leg5);
        Abs_Text.add("Reclining Big Toe Pose with Rope");
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
