package com.example.HospitalGuide;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cgpacalculator.R;

public class Main2ActivityDocs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_docs);

        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("Doctors");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));


    }

    public void dentist(View view) {
        final String[] items = {"*-  Dr.Ajay Arneja"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Dentist")

                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), items[which] + " is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton("OK", null);

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

        Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setBackgroundColor(Color.BLUE);
        button.setPadding(0, 0, 20, 0);
        button.setTextColor(Color.WHITE);
    }

    public void eyeDoc(View view) {
        final String[] items = {"*-  Dr.N.K.Gupta"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Eye Specialist")

                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), items[which] + " is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton("OK", null);

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

        Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setBackgroundColor(Color.BLUE);
        button.setPadding(0, 0, 20, 0);
        button.setTextColor(Color.WHITE);
    }

    public void genPhy(View view) {
        final String[] items = {"*-  Dr.Vijay Mohan\n", "*-  Arti Bharadwaj"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("General Physician")

                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), items[which] + " is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton("OK", null);

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

        Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setBackgroundColor(Color.BLUE);
        button.setPadding(0, 0, 20, 0);
        button.setTextColor(Color.WHITE);
    }

    public void patho(View view) {
        final String[] items = {"*-  Dr.Harjit Singh"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pathologist")

                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), items[which] + " is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton("OK", null);

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

        Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setBackgroundColor(Color.BLUE);
        button.setPadding(0, 0, 20, 0);
        button.setTextColor(Color.WHITE);
    }

    public void psycolo(View view) {
        final String[] items = {"1:-   Ms.Anusuya Hazarika\n" , "2:-   Dr.Neha Sharma\n", "3:-   Ms.Babita\n", "4:-   Ms.Anuradha\n","5:-   Ms.Shaveta Bhardwaj"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Psychology")

                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), items[which] + " is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton("OK", null);

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

        Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setBackgroundColor(Color.BLUE);
        button.setPadding(0, 0, 20, 0);
        button.setTextColor(Color.WHITE);
    }

    public void skin(View view) {
        final String[] items = {"*-  Dr.Mamta Arora"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Skin Doctor")

                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), items[which] + " is clicked", Toast.LENGTH_SHORT).show();
                    }
                });

        builder.setPositiveButton("OK", null);

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

        Button button = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setBackgroundColor(Color.BLUE);
        button.setPadding(0, 0, 20, 0);
        button.setTextColor(Color.WHITE);
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

