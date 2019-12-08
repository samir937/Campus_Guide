package com.example.cgpacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Profile_Activity extends AppCompatActivity {

    TextView textViewName,textViewEmail,textViewPhone,textViewShare;
    ImageView ProfileImage;
    String name,email,phoneNumber,imageUrl;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);

        textViewEmail=findViewById(R.id.emailText);
        textViewName=findViewById(R.id.nameText);
        textViewPhone=findViewById(R.id.phoneText);
        ProfileImage=findViewById(R.id.imageprofile);
        textViewShare=findViewById(R.id.shareText);

        textViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Lpu Campus Guide");
                    String shareMessage= "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://drive.google.com/file/d/11zfv0PSr60-YM_QgPODsMrkmoE7W_l2P/view?usp=sharing" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Profile");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));




        reference= FirebaseDatabase.getInstance().getReference();

        reference.child("Users").child(FirebaseAuth.getInstance().getUid()).child("User Details").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserPC user1=dataSnapshot.getValue(UserPC.class);
                    name = user1.getName();
                    email= user1.getEmail();
                    phoneNumber=user1.getPhoneNumber();
                    imageUrl=user1.getUri();

                    textViewName.setText(name);
                    textViewEmail.setText(email);
                    textViewPhone.setText(phoneNumber);

                    Picasso.get().load(imageUrl).into(ProfileImage);

                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




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
