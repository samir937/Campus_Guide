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

public class Bunk_Predictor extends AppCompatActivity {

    EditText class_attended,total_classes;
    int attendencePercentage,class_bunks;
    Button predictButton;
    int attended,total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bunk__predictor);
        class_attended=findViewById(R.id.attended_class);
        total_classes=findViewById(R.id.total_classes);
        predictButton=findViewById(R.id.predict);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("Bunk Predictor");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0A76D6")));

        predictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attended=Integer.parseInt(class_attended.getText().toString());
                total=Integer.parseInt(total_classes.getText().toString());

                attendencePercentage=  ((attended*100)/total);

                if(attendencePercentage<75)
                {
                    Toast.makeText(Bunk_Predictor.this,"You can't bunk any more classes",Toast.LENGTH_SHORT).show();
                }
                else {
                    class_bunks = ((attendencePercentage - 75) * (total)) / 100;
                    Toast.makeText(Bunk_Predictor.this,"You can leave "+class_bunks+" classes",Toast.LENGTH_SHORT).show();
                }

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
