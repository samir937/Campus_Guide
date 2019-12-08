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

public class Shoulder_Activity extends AppCompatActivity {
    ImageView shoulder_image1;
    RecyclerView shoulder_recyclerview;
    private ArrayList<Integer> Abs_image=new ArrayList<>();
    private ArrayList<String> Abs_Text=new ArrayList<>();
    private ArrayList<String> Abs_Text2=new ArrayList<>();
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoulder_);

        shoulder_image1=findViewById(R.id.shoulder_image1);
        shoulder_image1.setImageDrawable(getResources().getDrawable(R.drawable.shoulder));
        // abs_image1.setImageResource(R.drawable.abs);
        shoulder_recyclerview=findViewById(R.id.shoulder_recyclerview);


        shoulder_recyclerview.setHasFixedSize(true);

        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        shoulder_recyclerview.setLayoutManager(layoutManager4);
        getData3();
        Abs_Adapter adapter5=new Abs_Adapter(this,Abs_image,Abs_Text,Abs_Text2);
        shoulder_recyclerview.setAdapter(adapter5);

      /*  Toolbar shoulder_toolbar;
        shoulder_toolbar=findViewById(R.id.shoulder_toolbar);
        shoulder_toolbar.setTitle("Shoulder Excercise");
        setSupportActionBar(shoulder_toolbar);*/

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        actionBar.setTitle("Shoulder Excercise");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));
    }
    void getData3()
    {
        Abs_image.add(R.drawable.shoulder1);
        Abs_Text.add("Cable Standing Cross Over");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.shoulder2);
        Abs_Text.add("Cable Seated High Row");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.shoulder31);
        Abs_Text.add("Cable Floor Seated Wide Grip Row");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.shoulder41);
        Abs_Text.add("Standing Chin-Up");
        Abs_Text2.add("3 x 15 wraps");

        Abs_image.add(R.drawable.shoulder5);
        Abs_Text.add("Barbell Reverse Grip Incline Bench Row");
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
