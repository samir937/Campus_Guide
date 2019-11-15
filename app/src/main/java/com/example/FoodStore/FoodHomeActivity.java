package com.example.FoodStore;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.cgpacalculator.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FoodHomeActivity extends AppCompatActivity {

    String filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle bundle = getIntent().getExtras();
        filter = bundle.getString("shop");

        BottomNavigationView bnav = findViewById(R.id.home_nav);

        Bundle bd=new Bundle();
        bd.putString("shop",filter);
        Fragment fb=new Menu();
        fb.setArguments(bd);
        getSupportFragmentManager().beginTransaction().replace(R.id.home_frag, fb).commit();
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
                            fb=new Menu();
                            break;
                        case R.id.nav_order:
                            fb=new Cart();
                            break;
                    }

                    Bundle bd=new Bundle();
                    bd.putString("shop",filter);
                    fb.setArguments(bd);
                    getSupportFragmentManager().beginTransaction().replace(R.id.home_frag,fb).commit();
                    return true;
                }
            };
}