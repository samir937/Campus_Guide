package com.example.cgpacalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cgpa_Predictor extends AppCompatActivity {
    EditText currentCgpa,expectedCgpa,sem_left;
    Button predict_button;
    int sems;
    Double current_cgpa_value,expected_cgpa_value,total_cgpa,required_tgpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa__predictor);
        currentCgpa=findViewById(R.id.current_cgpa);
        expectedCgpa=findViewById(R.id.expected_cgpa);
        sem_left=findViewById(R.id.semester_left);
        predict_button=findViewById(R.id.Predict);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("CGPA Predictor");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0A76D6")));

        predict_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current_cgpa_value=Double.parseDouble(currentCgpa.getText().toString());
                expected_cgpa_value=Double.parseDouble(expectedCgpa.getText().toString());
                sems=Integer.parseInt(sem_left.getText().toString());
                total_cgpa=(current_cgpa_value*(8-sems));
                required_tgpa=((expected_cgpa_value*8)-(total_cgpa))/2;

                Toast.makeText(Cgpa_Predictor.this,"You wil have to maintain a minimum of %.2f "+required_tgpa+" in all your upcoming semester",Toast.LENGTH_SHORT).show();

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
