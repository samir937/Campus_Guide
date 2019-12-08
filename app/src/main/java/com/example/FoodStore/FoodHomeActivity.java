package com.example.FoodStore;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cgpacalculator.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.razorpay.PaymentResultListener;

import java.util.ArrayList;

    public class FoodHomeActivity extends AppCompatActivity implements PaymentResultListener
    {
        String filter;
        static String uname,uphone,uaddress;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_food_home);


            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
            actionBar.setTitle("Food");
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));

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

        @Override
        public void onPaymentSuccess(String s)
        {
            placeOrder();
            SingletonCart.getInstance().arr=new ArrayList<>();
            Toast.makeText(getApplicationContext(),"Your Food is successfully ordered",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPaymentError(int i, String s) {

        }

        public void placeOrder()
        {
            DatabaseReference data_ref= FirebaseDatabase.getInstance().getReference("Orders");
            ArrayList<ModelOrder> arr=SingletonCart.getInstance().arr;
            for(int i=0;i<arr.size();i++)
            {
                ModelOrder ob=arr.get(i);
                ob.setUname(uname);
                ob.setUphone(uphone);
                ob.setUaddress(uaddress);
                String uploadid=data_ref.push().getKey();
                ob.setKey(uploadid);
                data_ref.child(uploadid).setValue(ob);
            }
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
