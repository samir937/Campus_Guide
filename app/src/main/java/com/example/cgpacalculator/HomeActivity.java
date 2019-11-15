package com.example.cgpacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import de.hdodenhof.circleimageview.CircleImageView;

import android.content.Intent;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.FoodStore.FoodActivity;
import com.example.HospitalGuide.HospitalActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

   Button profileBtn, bunkBtn, gymBtn, mapBtn, tgpaBtn, healthBtn,foodBtn;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    CircleImageView imageViewUser;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase database;
    DatabaseReference reference;
    TextView emailid,nameText;
    String uid,name,email,imageUrl;
    View headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        profileBtn = findViewById(R.id.buttonProfile);
        tgpaBtn = findViewById(R.id.buttonTgpa);
        healthBtn = findViewById(R.id.buttonHealth);
        bunkBtn = findViewById(R.id.buttonBunk);
        gymBtn = findViewById(R.id.buttonGym);
        foodBtn=findViewById(R.id.buttonFood);
        mapBtn = findViewById(R.id.buttonMap);
        drawerLayout=findViewById(R.id.drawer);
        firebaseAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        uid = user.getUid();
        userDetail(uid);

        toggle = new ActionBarDrawerToggle(
               this, drawerLayout,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        headerView = navigationView.getHeaderView(0);
        nameText=headerView.findViewById(R.id.userName);
        emailid=headerView.findViewById(R.id.emailId);
        imageViewUser=headerView.findViewById(R.id.profile_image);


        profileBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,Cgpa_Predictor.class));

           }
       });

       tgpaBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,add_subject_acitivity.class));
           }
       });



       mapBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,MapActivity.class));
           }
       });

       gymBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               FirebaseAuth.getInstance().signOut();
               startActivity(new Intent(HomeActivity.this,Login.class));
               finishAffinity();
           }
       });

       bunkBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,Bunk_Predictor.class));
           }
       });

       foodBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(HomeActivity.this,FoodActivity.class));
           }
       });

        //FirebaseAuth.getInstance().signOut();
       healthBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               startActivity(new Intent(HomeActivity.this, HospitalActivity.class));
           }
       });

    }

   public void userDetail(String uid){
        reference.child("Users").child(uid).child("User Details").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                UserPC user=dataSnapshot.getValue(UserPC.class);
                name = user.getName();
                email= user.getEmail();
                imageUrl=user.getUri();

                nameText.setText(name);
                emailid.setText(email);
                Picasso.get().load(imageUrl).into(imageViewUser);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected( MenuItem item) {

        if(toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        int id = menuItem.getItemId();

        if (id == R.id.logout) {
            Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}






