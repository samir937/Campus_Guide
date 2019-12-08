package com.example.cgpacalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bunk_Predictor extends AppCompatActivity {

    EditText class_attended,total_classes;
    TextView bunk;
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
        bunk=findViewById(R.id.Bunkresult);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("Bunk Predictor");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));

        predictButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if(class_attended.getText().toString().equals(""))
                {
                    class_attended.setError("Enter Value");
                }
                else
                {
                    attended=Integer.parseInt(class_attended.getText().toString());
                }
                if(total_classes.getText().toString().equals(""))
                {
                    total_classes.setError("Enter Values");
                }
                else
                {
                    total=Integer.parseInt(total_classes.getText().toString());
                }

                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.RESULT_UNCHANGED_SHOWN);

                if(!class_attended.getText().toString().equals("")&& !total_classes.getText().toString().equals(""))
                {
                    attendencePercentage=  ((attended*100)/total);

                    if(attendencePercentage<=75)
                    {
                        bunk.setTextColor(Color.RED);
                        bunk.setText("You can't bunk any more classes");

                    }
                    else {
                        class_bunks = ((attendencePercentage - 75) * (total)) / 100;
                        bunk.setTextColor(Color.GREEN);
                        bunk.setText("You can leave "+class_bunks+" classes");
                    }
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
