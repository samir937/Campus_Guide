package com.example.GymGuide;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.cgpacalculator.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GymActivtiy extends AppCompatActivity {
    RecyclerView dashboard_recyclerview;
    Toolbar toolbar;
    private ArrayList<Integer> recipeImage1=new ArrayList<>();
    private ArrayList<String> recipeprice1=new ArrayList<>();

    BottomNavigationView bottom_navi;

    private ViewFlipper simpleViewFlipper;
    int[] images = {R.drawable.biceps22,R.drawable.chest11,R.drawable.breakfast,R.drawable.diet2,R.drawable.diet4,R.drawable.diet5,R.drawable.diet6,R.drawable.diet7};     // array of images

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        dashboard_recyclerview=(RecyclerView) findViewById(R.id.dashboard_recyclerview);
        dashboard_recyclerview.setHasFixedSize(true);


        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Gym Guide");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));

        //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GridLayoutManager layoutManager1 = new GridLayoutManager(this,2,LinearLayoutManager.HORIZONTAL,false);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);

        dashboard_recyclerview.setLayoutManager(layoutManager1);
        getData3();
        Dashboard_Adapter adapter5=new Dashboard_Adapter(this,recipeImage1,recipeprice1);
        dashboard_recyclerview.setAdapter(adapter5);

        bottom_navi=findViewById(R.id.bottom_navi);

        //bottom_navi.setOnNavigationItemSelectedListener(new On);
        bottom_navi.setOnNavigationItemSelectedListener(navListener);
        bottom_navi.setItemIconTintList(null);

        simpleViewFlipper = findViewById(R.id.simpleViewFlipper);
        for (int i = 0; i < images.length; i++) {

            ImageView imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            simpleViewFlipper.addView(imageView);
        }
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setOutAnimation(out);

        simpleViewFlipper.setFlipInterval(2000);

        simpleViewFlipper.setAutoStart(true);


    }

    private void getData3() {

        recipeImage1.add(R.drawable.workout4);
        recipeprice1.add("Workout");


        recipeImage1.add(R.drawable.protein3);
        recipeprice1.add("Protein");

        recipeImage1.add(R.drawable.users);
        recipeprice1.add("Membership");

        recipeImage1.add(R.drawable.dietplan3);
        recipeprice1.add("Diet Plan");

        // recipeImage1.add(R.drawable.calorymeter);
        //  recipeprice1.add("CaloryMeter");


    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId())
                    {
                      /*  case R.id.nav_home:
                            startActivity(new Intent(MainActivity.this,MainActivity.class));
                            break;
                        */
                        case R.id.nav_protein:

                            startActivity(new Intent(GymActivtiy.this,Protien_Activity.class));
                            break;

                        case R.id.nav_user:
                            startActivity(new Intent(GymActivtiy.this,Membership_Activity.class));
                            break;

                        case R.id.nav_diet:
                            startActivity(new Intent(GymActivtiy.this,Diet_Activity.class));
                            break;

                    }
                    return true;
                }
            };
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
