package com.example.HospitalGuide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.cgpacalculator.R;

public class FactDetail extends AppCompatActivity {

    ImageView imageView;
    int[] contents= {R.drawable.opdd,R.drawable.opdchargess,R.drawable.ambulanceee,R.drawable.emergencyyy,R.drawable.patientadddddd,R.drawable.time};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact_detail);
        int iNo=getIntent().getExtras().getInt("num");
        imageView=findViewById(R.id.imageFact);
        imageView.setImageResource(contents[iNo]);

        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("Facilities");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
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