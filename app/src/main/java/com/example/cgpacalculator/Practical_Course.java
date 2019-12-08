package com.example.cgpacalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static java.lang.Math.ceil;

public class Practical_Course extends AppCompatActivity {
    EditText Lab1_marks, Lab2_marks,Lab3_marks, lab_attendence_perc, lab_credit,Lab_ete_marks, lab_course_code;
    Button submit;
    Double ca_weightage, mte_weightage, ete_weightage, total_marks, ca, mte, ete;
    int marks_Lab1, marks_Lab2, marks_Lab3, marks_ete, attendence_percentage, course_credit, attendence_weightage, gpa;
    String Grade, semester, course;
    Spinner semspin;
    RelativeLayout relativeLayout;
    DatabaseReference mref;
    String userid;
    String sems[] = {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical__course);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("TGPA CALCULATOR");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));



        lab_course_code = findViewById(R.id.course_code);
        lab_attendence_perc = findViewById(R.id.Attendence);
        lab_credit = findViewById(R.id.credits);
        Lab1_marks = findViewById(R.id.Lab1);
        Lab2_marks = findViewById(R.id.Lab2);
        Lab3_marks = findViewById(R.id.Lab3);
        Lab_ete_marks = findViewById(R.id.lab_ete);
        semspin = findViewById(R.id.semList1);

        relativeLayout = findViewById(R.id.Layout_normal_course);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
            }
        });

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, sems);
        semspin.setAdapter(arrayAdapter);

        submit = findViewById(R.id.save);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(Lab1_marks.getText().toString())) {
                    Lab1_marks.setError("Enter ca1 marks");
                } else {
                    marks_Lab1 = Integer.parseInt(Lab1_marks.getText().toString());
                }
                if (marks_Lab1 > 50 ||marks_Lab1 < 0) {
                    Lab1_marks.setError("Enter a valid ca marks");
                }

                if (TextUtils.isEmpty(Lab2_marks.getText().toString())) {
                    Lab2_marks.setError("Enter ca2 marks");
                } else {
                    marks_Lab2= Integer.parseInt(Lab2_marks.getText().toString());
                }
                if (marks_Lab2 > 50 || marks_Lab2<0) {
                    Lab2_marks.setError("Enter a valid ca marks");
                }

                if (TextUtils.isEmpty(Lab3_marks.getText().toString())) {
                    Lab3_marks.setError("Enter Lab3 marks");
                } else {
                    marks_Lab3 = Integer.parseInt(Lab3_marks.getText().toString());
                }
                if (marks_Lab3 > 50 ||marks_Lab3<0) {
                    Lab3_marks.setError("Enter a valid mte marks");
                }
                if (TextUtils.isEmpty(Lab_ete_marks.getText().toString())) {
                    Lab_ete_marks.setError("Enter ete marks");
                } else {
                    marks_ete = Integer.parseInt(Lab_ete_marks.getText().toString());
                }
                if (marks_ete > 100 ||marks_ete<0) {
                    Lab_ete_marks.setError("Enter a valid ete marks");
                }
                if (TextUtils.isEmpty(lab_attendence_perc.getText().toString())) {
                    lab_attendence_perc.setError("Enter your attendence");
                } else {
                    attendence_percentage = Integer.parseInt(lab_attendence_perc.getText().toString());
                }
                if (attendence_percentage > 100) {
                    lab_attendence_perc.setError("Enter a valid attendence");
                }
                if (TextUtils.isEmpty(lab_course_code.getText().toString())) {
                    lab_course_code.setError("Enter the course code");
                } else {
                    course = lab_course_code.getText().toString();
                }
                if (TextUtils.isEmpty(lab_credit.getText().toString())) {
                    lab_credit.setError("Enter the course credit");
                } else {
                    course_credit = Integer.parseInt(lab_credit.getText().toString());
                }
                if (course_credit < 1) {
                    lab_credit.setError("Enter a valid course credit");
                }


                if(marks_Lab1<=50 && marks_Lab2<=50&& marks_Lab3<=50 && marks_ete<=100 && !Lab1_marks.getText().toString().equals("") && !lab_credit.getText().toString().equals("") && !Lab2_marks.getText().toString().equals("") && !Lab3_marks.getText().toString().equals("") && !lab_attendence_perc.getText().toString().equals("") && !lab_course_code.getText().toString().equals("") )
                {
                    ca_weightage = ((0.30 * marks_Lab1) + (0.30 * marks_Lab2)+(0.30 * marks_Lab3));
                    mte_weightage = 0.0d;
                    ete_weightage = (0.50 * marks_ete);

                    if (attendence_percentage >= 90)
                        attendence_weightage = 5;
                    else if (attendence_percentage >= 85)
                        attendence_weightage = 4;
                    else if (attendence_percentage >= 80)
                        attendence_weightage = 3;
                    else if (attendence_percentage >= 75)
                        attendence_weightage = 2;
                    else
                        attendence_weightage = 0;


                    ca = Math.round(ca_weightage * 100.0) / 100.0;
                    mte = Math.round(mte_weightage * 100.0) / 100.0;
                    ete = Math.round(ete_weightage * 100.0) / 100.0;
                    total_marks = ca + ete + mte + attendence_weightage;

                    total_marks = Math.round(total_marks * 100.0) / 100.0;

                    if (total_marks > 85)
                        Grade = "O";
                    else if (total_marks > 75)
                        Grade = "A+";
                    else if (total_marks > 70)
                        Grade = "A";
                    else if (total_marks > 65)
                        Grade = "B+";
                    else if (total_marks > 58)
                        Grade = "B";
                    else if (total_marks > 50)
                        Grade = "C+";
                    else if (total_marks > 45)
                        Grade = "C";
                    else if (total_marks > 40)
                        Grade = "D";
                    else
                        Grade = "E";


                    if (Grade.equals("O"))
                        gpa = 10;
                    else if (Grade.equals("A+"))
                        gpa = 9;
                    else if (Grade.equals("A"))
                        gpa = 8;
                    else if (Grade.equals("B+"))
                        gpa = 7;
                    else if (Grade.equals("B"))
                        gpa = 6;
                    else if (Grade.equals("C+"))
                        gpa = 5;
                    else if (Grade.equals("C"))
                        gpa = 4;
                    else if (Grade.equals("D"))
                        gpa = 3;
                    else
                        gpa = 0;


                    semester = semspin.getSelectedItem().toString().trim();
                    userid = FirebaseAuth.getInstance().getUid();
                    mref = FirebaseDatabase.getInstance().getReference("Users").child(userid).child("Semesters").child(semester);

                    if (semester.equals("Semester1")) {
                        SubjectDetails subjectDetails = new SubjectDetails(course, attendence_weightage, course_credit, ca, mte, ete, total_marks, Grade, gpa);
                        mref.child("subjects").push().setValue(subjectDetails);
                        Toast.makeText(Practical_Course.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Practical_Course.this,ShowData.class));

                    } else if (semester.equals("Semester2")) {
                        SubjectDetails subjectDetails = new SubjectDetails(course, attendence_weightage, course_credit, ca, mte, ete, total_marks, Grade, gpa);
                        mref.child("subjects").push().setValue(subjectDetails);
                        Toast.makeText(Practical_Course.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Practical_Course.this,ShowData.class));

                    } else if (semester.equals("Semester3")) {
                        SubjectDetails subjectDetails = new SubjectDetails(course, attendence_weightage, course_credit, ca, mte, ete, total_marks, Grade, gpa);
                        mref.child("subjects").push().setValue(subjectDetails);
                        Toast.makeText(Practical_Course.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Practical_Course.this,ShowData.class));

                    } else if (semester.equals("Semester4")) {
                        SubjectDetails subjectDetails = new SubjectDetails(course, attendence_weightage, course_credit, ca, mte, ete, total_marks, Grade, gpa);
                        mref.child("subjects").push().setValue(subjectDetails);
                        Toast.makeText(Practical_Course.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Practical_Course.this,ShowData.class));

                    } else if (semester.equals("Semester5")) {
                        SubjectDetails subjectDetails = new SubjectDetails(course, attendence_weightage, course_credit, ca, mte, ete, total_marks, Grade, gpa);
                        mref.child("subjects").push().setValue(subjectDetails);
                        Toast.makeText(Practical_Course.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Practical_Course.this,ShowData.class));

                    } else if (semester.equals("Semester6")) {
                        SubjectDetails subjectDetails = new SubjectDetails(course, attendence_weightage, course_credit, ca, mte, ete, total_marks, Grade, gpa);
                        mref.child("subjects").push().setValue(subjectDetails);
                        Toast.makeText(Practical_Course.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Practical_Course.this,ShowData.class));

                    } else if (semester.equals("Semester7")) {
                        SubjectDetails subjectDetails = new SubjectDetails(course, attendence_weightage, course_credit, ca, mte, ete, total_marks, Grade, gpa);
                        mref.child("subjects").push().setValue(subjectDetails);
                        Toast.makeText(Practical_Course.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Practical_Course.this,ShowData.class));

                    } else if (semester.equals("Semester8")) {
                        SubjectDetails subjectDetails = new SubjectDetails(course, attendence_weightage, course_credit, ca, mte, ete, total_marks, Grade, gpa);
                        mref.child("subjects").push().setValue(subjectDetails);
                        Toast.makeText(Practical_Course.this, "Data inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Practical_Course.this,ShowData.class));

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