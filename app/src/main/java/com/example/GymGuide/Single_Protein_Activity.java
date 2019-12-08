package com.example.GymGuide;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cgpacalculator.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Single_Protein_Activity extends AppCompatActivity {
    Toolbar single_protein_toolbar;
    ImageView single_protein_images;
    TextView single_protein_name,single_weight,single_decription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single__protein_);

        /*single_protein_toolbar=findViewById(R.id.single_protein_toolbar);
        single_protein_toolbar.setTitle(" Protein Details");
        setSupportActionBar(single_protein_toolbar);*/
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Protein Details");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));


        single_protein_images=findViewById(R.id.single_protein_images);
        single_protein_name=findViewById(R.id.single_protein_name);
        single_weight=findViewById(R.id.single_weight);
        single_decription=findViewById(R.id.single_decription);

        Intent intent = getIntent();

        single_protein_images.setImageResource(intent.getIntExtra("protein_image",1));
        single_protein_name.setText("Name : "+intent.getStringExtra("protein_name"));

        single_weight.setText("Weight : "+intent.getStringExtra("protein_weight"));
        single_decription.setText("About the Protein : \n"+intent.getStringExtra("protein_description"));
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
