package com.example.HospitalGuide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cgpacalculator.R;

public class HospitalHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_home);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("Hospital Guide");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));
    }

    public void emergency(View view) {

        final String[] items = {"1:-   24 HOURS HELPLINE\n" +
                "+91-1824-501227\n" , "2:-   HOSPITAL RECEPTION 1\n" +
                "PH: 911824444079, EXT: 4079\n", "3:-   HOSPITAL LABORATORY\n" +
                "PH: 911824444069, EXT: 4069\n", "4:-   HOSPITAL MALE WARD\n" +
                "PH: 911824444066, EXT: 4066\n","5:-   HOSPITAL FEMALE WARD\n" +
                "PH: 911824444067, EXT: 4067"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("List of Items")

                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), items[which] + " is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton("OK", null);

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

        Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setBackgroundColor(Color.BLACK);
        button.setPadding(0, 0, 20, 0);
        button.setTextColor(Color.WHITE);
    }

    public void facility(View view) {
        Intent myIntent = new Intent(getBaseContext(),Facilities.class);
        startActivity(myIntent);
    }

    public void Doctor(View view) {
        Intent myIntent = new Intent(getBaseContext(),Main2ActivityDocs.class);
        startActivity(myIntent);
    }


    public void appointment(View view) {
        Intent myIntent = new Intent(getBaseContext(),Appointments.class);
        startActivity(myIntent);
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
