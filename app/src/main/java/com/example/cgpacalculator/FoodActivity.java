package com.example.cgpacalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class FoodActivity extends AppCompatActivity {
    FirebaseAuth fbauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        BottomNavigationView bnav=findViewById(R.id.home_nav);
        getSupportFragmentManager().beginTransaction().replace(R.id.sp_main_frag,new com.example.cgpacalculator.Menu()).commit();
        bnav.setOnNavigationItemSelectedListener(nlistener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener nlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener()
            {
                public boolean onNavigationItemSelected(MenuItem item)
                {
                    Fragment fb=null;
                    switch (item.getItemId())
                    {
                        case R.id.nav_menu:
                            fb=new com.example.cgpacalculator.Menu();
                            break;
                        case R.id.nav_order:
                            fb=new com.example.cgpacalculator.Cart();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.sp_main_frag,fb).commit();
                    return true;
                }
            };

/*
    public void getAuthorised()
    {
        fbauth.signInWithEmailAndPassword("samirpattanaik14@gmail.com","samir123")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                    }
                });
    }*/
}