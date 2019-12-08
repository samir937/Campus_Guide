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
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Workout_Activity extends AppCompatActivity {
    RecyclerView workout_recyclerview;
    ImageView workout_top_image;
    Toolbar workout_toolbar;
    private ArrayList<Integer> ExcerciseImage1=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_);
        workout_recyclerview=findViewById(R.id.workout_recyclerview);
        //workout_top_image=findViewById(R.id.workout_top_image);
       // workout_top_image.setImageResource(R.drawable.workout_top);

        workout_recyclerview.setHasFixedSize(true);

        @SuppressLint("WrongConstant") LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
       workout_recyclerview.setLayoutManager(layoutManager4);
        getData3();
       Workout_Activity_Adapter adapter5=new Workout_Activity_Adapter(this,ExcerciseImage1);
       workout_recyclerview.setAdapter(adapter5);


        /*workout_toolbar=findViewById(R.id.workout_toolbar);
       workout_toolbar.setTitle("Excercise Details");
       setSupportActionBar(workout_toolbar);*/

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Excercise Details");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));

    }
    private void getData3() {

        ExcerciseImage1.add(R.drawable.abs);
        ExcerciseImage1.add(R.drawable.arms);
        ExcerciseImage1.add(R.drawable.chest);
        ExcerciseImage1.add(R.drawable.shoulder);
        ExcerciseImage1.add(R.drawable.legs);



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
