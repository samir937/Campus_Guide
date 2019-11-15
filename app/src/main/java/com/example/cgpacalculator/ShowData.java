package com.example.cgpacalculator;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ShowData extends AppCompatActivity {

    ArrayList<SubjectDetails> subjects;
    DatabaseReference reference;
    MyListAdapter adapter;
    Spinner spinner;
    String sem;
    ProgressDialog progressDialog;
    TextView total;
    Button show_marks;
    FloatingActionButton addButton;
    RecyclerView recyclerView;
    double creditsum = 0.0d, totalGpa = 0.0d;
    int i = 0;
    String sems[] = {"Choose Semester","Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        subjects = new ArrayList<SubjectDetails>();
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sems);
        spinner.setAdapter(arrayAdapter);
        total = findViewById(R.id.tgpaText);
        show_marks=findViewById(R.id.show_data);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Toast.makeText(ShowData.this,"Choose a Semester",Toast.LENGTH_SHORT).show();

        actionBar.setTitle("TGPA CALCULATOR");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0A76D6")));

        addButton=findViewById(R.id.addSubjects);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ShowData.this,MainActivity.class));
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recyclerList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        sem = spinner.getSelectedItem().toString().trim();

       /* spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 1: se
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/
         show_marks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {

                    subjects.clear();

                    sem = spinner.getSelectedItem().toString().trim();
                    if(sem.equals("Choose Semester"))
                    {
                       Toast.makeText(ShowData.this,"Choose a semester first",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {

                        reference = FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getUid()).child("Semesters").child(sem).child("subjects");

                        progressDialog = new ProgressDialog(ShowData.this);
                        progressDialog.setMessage("Loading Please Wait...");
                        progressDialog.setCancelable(false);
                        //progressDialog.setTitle("ProgressDialog bar example");
                        // progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progressDialog.show();

                        reference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists()) {
                                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                        SubjectDetails subs = dataSnapshot1.getValue(SubjectDetails.class);
                                        subjects.add(subs);
                                        progressDialog.dismiss();
                                    }

                                    while (i < subjects.size()) {
                                        totalGpa += ((subjects.get(i).getGPA()) * (subjects.get(i).getCredit()));
                                        creditsum += subjects.get(i).getCredit();
                                        i++;
                                    }

                                    total.setText(String.valueOf(Math.round((totalGpa / creditsum) * 100.0) / 100.0));
                                    adapter = new MyListAdapter(ShowData.this, subjects);
                                    recyclerView.setAdapter(adapter);
                                }
                                else
                                {
                                    Snackbar snackbar = Snackbar
                                            .make(v, "N0 Data Found", Snackbar.LENGTH_LONG);

                                    snackbar.show();

                                    progressDialog.dismiss();
                                }
                                }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Toast.makeText(ShowData.this, "oops something went wrong ", Toast.LENGTH_SHORT).show();
                            }
                        });

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
