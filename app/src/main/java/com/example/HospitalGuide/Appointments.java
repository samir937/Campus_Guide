package com.example.HospitalGuide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cgpacalculator.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class  Appointments extends AppCompatActivity {

    EditText editDocType,editRegno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        editDocType = (EditText) findViewById(R.id.editName);
        editRegno= (EditText) findViewById(R.id.editRegno);

        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setTitle("Appointments");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));
    }

    public void  save(View view)  // SAVE
    {
        File file= null;
        String name = editDocType.getText().toString();
        String regino = editRegno.getText().toString();

        FileOutputStream fileOutputStream = null;
        try {
            name = name + " ";
            file = getFilesDir();


            fileOutputStream = openFileOutput("Code.txt", Context.MODE_PRIVATE); //MODE PRIVATE
            fileOutputStream.write(name.getBytes());
            fileOutputStream.write(regino.getBytes());
            Toast.makeText(this, "Saved \n" + "Your Appointment Has been Made", Toast.LENGTH_SHORT).show();
            editDocType.setText("");
            editRegno.setText("");
            return;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void  next( View view)   //NEXT
    {
        Toast.makeText(this,"NEXT", Toast.LENGTH_SHORT).show();
        Intent intent= new Intent(this, AppointCheck.class);
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