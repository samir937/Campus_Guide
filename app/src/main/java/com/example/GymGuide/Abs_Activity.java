package com.example.GymGuide;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.cgpacalculator.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Abs_Activity extends AppCompatActivity {
    ImageView abs_image1;
    RecyclerView abs_recyclerview;
    private ArrayList<Integer> Abs_image=new ArrayList<>();
    private ArrayList<String> Abs_Text=new ArrayList<>();
    private ArrayList<String> Abs_Text2=new ArrayList<>();
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abs_);

        abs_image1=findViewById(R.id.abs_image1);
        abs_image1.setImageDrawable(getResources().getDrawable(R.drawable.abs));
       // abs_image1.setImageResource(R.drawable.abs);
        abs_recyclerview=findViewById(R.id.abs_recyclerview);


        abs_recyclerview.setHasFixedSize(true);

        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        abs_recyclerview.setLayoutManager(layoutManager4);
        getData3();
        Abs_Adapter adapter5=new Abs_Adapter(this,Abs_image,Abs_Text,Abs_Text2);
        abs_recyclerview.setAdapter(adapter5);

       /* Toolbar abs_toolbar;
        abs_toolbar=findViewById(R.id.abs_toolbar);
        abs_toolbar.setTitle("Abs Excercise");

        setSupportActionBar(abs_toolbar);


*/

        getSupportActionBar().setTitle("Abs Excercise");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));
    }
    void getData3()
    {
        Abs_image.add(R.drawable.abs1);
        Abs_Text.add("Hanging Leg Hip Raise");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.abs2);
        Abs_Text.add("Cable Kneeling Crunch");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.abs3);
        Abs_Text.add("Cable Seated Crunch");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.abs4);
        Abs_Text.add("Suspended Reverse Crunch");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.abs5);
        Abs_Text.add("Bottoms Up");
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