package com.example.cgpacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;


import com.example.FoodStore.FoodActivity;
import com.example.GymGuide.GymActivtiy;
import com.example.HospitalGuide.HospitalHome;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    Button AboutUsBtn, bunkBtn, gymBtn, mapBtn, tgpaBtn, healthBtn, foodBtn, chatBtn,cgpaBtn,profileBtn;
    DatabaseReference reference;
    String uid, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        cgpaBtn=findViewById(R.id.cgpaButton);
        profileBtn=findViewById(R.id.buttonProfile);
        AboutUsBtn = findViewById(R.id.buttonAboutUs);
        tgpaBtn = findViewById(R.id.buttonTgpa);
        healthBtn = findViewById(R.id.buttonHealth);
        bunkBtn = findViewById(R.id.buttonBunk);
        gymBtn = findViewById(R.id.buttonGym);
        foodBtn = findViewById(R.id.buttonFood);
        mapBtn = findViewById(R.id.buttonMap);
        chatBtn = findViewById(R.id.chat);
        reference = FirebaseDatabase.getInstance().getReference();



        getSupportActionBar().setTitle("Lpu Campus Guide");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));

        getuserName(FirebaseAuth.getInstance().getUid());


        AboutUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AboutUsActivity.class));

            }
        });


        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,Profile_Activity.class));
            }
        });

        cgpaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,Cgpa_Predictor.class));
            }
        });

        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeActivity.this, ChatWithUs.class);
                intent.putExtra("user_name", name);
                startActivity(intent);
            }
        });

        tgpaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.child("Users").child(FirebaseAuth.getInstance().getUid()).child("Semesters").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        int size = (int) dataSnapshot.getChildrenCount();
                        if (size > 0) {
                            startActivity(new Intent(getApplicationContext(), ShowData.class));
                        } else {
                            startActivity(new Intent(HomeActivity.this, add_subject_acitivity.class));
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });


        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MapActivity.class));
            }
        });

        gymBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this, GymActivtiy.class));

            }
        });

        bunkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Bunk_Predictor.class));
            }
        });

        foodBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, FoodActivity.class));
            }
        });


        healthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this, HospitalHome.class));
            }
        });

    }

public void getuserName(String uid)
{

    reference.child("Users").child(uid).child("User Details").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            UserPC user1=dataSnapshot.getValue(UserPC.class);
            name = user1.getName();

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }

    });

}

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(HomeActivity.this,Login.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}






