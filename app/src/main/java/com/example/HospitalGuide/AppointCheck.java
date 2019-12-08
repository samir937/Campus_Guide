package com.example.HospitalGuide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cgpacalculator.R;

import java.io.FileInputStream;

public class AppointCheck extends AppCompatActivity {

    TextView getDocname, getReg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoint_check);
        getDocname = (TextView)findViewById(R.id.getname);
        getReg = (TextView)findViewById(R.id.getreg);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("TGPA CALCULATOR");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));

    }
    public void  load(View view)
    {
        try {
            FileInputStream fileInputStream =  openFileInput("Code.txt");
            int read = -1;
            StringBuffer buffer = new StringBuffer();
            while((read =fileInputStream.read())!= -1){
                buffer.append((char)read);
            }
            Log.d("Code", buffer.toString());
            String docname = buffer.substring(0,buffer.indexOf(" "));
            String Reg = buffer.substring(buffer.indexOf(" ")+1);
            getDocname.setText(docname);
            getReg.setText(Reg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"Loaded", Toast.LENGTH_SHORT).show();
    }

    public void  back( View view)
    {
        Toast.makeText(this,"Back", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this, Appointments.class);
        startActivity(intent);
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

