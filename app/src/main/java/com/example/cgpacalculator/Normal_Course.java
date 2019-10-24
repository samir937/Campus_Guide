package com.example.cgpacalculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

public class Normal_Course extends AppCompatActivity {
    EditText ca1_marks,ca2_marks,attendence_perc,credit,mte_marks,ete_marks,course_code;
    Button submit,showbutton;
    Double ca_weightage,mte_weightage,ete_weightage,total_marks,tgpa;
    int marks_ca1,marks_ca2,marks_mte,marks_ete,attendence_percentage,course_credit,attendence_weightage,gpa;
    String Grade,semester,course;
    Spinner semspin;
    RelativeLayout relativeLayout;
    DatabaseReference mref;
    String userid;
    ArrayList<SubjectDetails> subjectsSem1,subjectsSem2,subjectsSem3,subjectsSem4,subjectsSem5,subjectsSem6,subjectsSem7,subjectsSem8;
    String sems[]={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal__course);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("TGPA CALCULATOR");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0A76D6")));

        showbutton=findViewById(R.id.show);
        showbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Normal_Course.this,ShowData.class));
            }
        });

        course_code=findViewById(R.id.course_code);
        attendence_perc=findViewById(R.id.Attendence);
        credit=findViewById(R.id.credits);
        ca1_marks=findViewById(R.id.ca1);
        ca2_marks=findViewById(R.id.ca2);
        mte_marks=findViewById(R.id.mte);
        ete_marks=findViewById(R.id.ete);
        semspin=findViewById(R.id.semList);

        subjectsSem1=new ArrayList<>();
        subjectsSem2=new ArrayList<>();
        subjectsSem3=new ArrayList<>();
        subjectsSem4=new ArrayList<>();
        subjectsSem5=new ArrayList<>();
        subjectsSem6=new ArrayList<>();
        subjectsSem7=new ArrayList<>();
        subjectsSem8=new ArrayList<>();

        relativeLayout=findViewById(R.id.Layout_normal_course);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager= (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
            }
        });

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,sems);
        semspin.setAdapter(arrayAdapter);

        submit=findViewById(R.id.save);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                marks_ca1 = Integer.parseInt(ca1_marks.getText().toString());
                marks_ca2 = Integer.parseInt(ca2_marks.getText().toString());
                marks_mte = Integer.parseInt(mte_marks.getText().toString());
                marks_ete = Integer.parseInt(ete_marks.getText().toString());
                attendence_percentage = Integer.parseInt(attendence_perc.getText().toString());
                course_credit = Integer.parseInt(credit.getText().toString());
                course=course_code.getText().toString();

                    ca_weightage = ((0.416 * marks_ca1) + (0.416 * marks_ca2));
                    mte_weightage = ceil(marks_mte / 2);
                    ete_weightage = (0.714 * marks_ete);

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


                    total_marks = ca_weightage + ete_weightage + mte_weightage + attendence_weightage;

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



                semester=semspin.getSelectedItem().toString().trim();
                userid= FirebaseAuth.getInstance().getUid();
                mref= FirebaseDatabase.getInstance().getReference("Users").child(userid).child("Semesters").child(semester);

                if(semester.equals("Semester1"))
                {
                    subjectsSem1.add(new SubjectDetails(course,attendence_weightage,course_credit,ca_weightage,mte_weightage,ete_weightage,total_marks,Grade,gpa));
                    mref.child("subjects").setValue(subjectsSem1);

                    Toast.makeText(Normal_Course.this,"Data inserted",Toast.LENGTH_SHORT).show();

                }
                else if(semester.equals("Semester2"))
                {
                    subjectsSem2.add(new SubjectDetails(course,attendence_weightage,course_credit,ca_weightage,mte_weightage,ete_weightage,total_marks,Grade,gpa));
                    mref.child("Subjects").setValue(subjectsSem2);

                    Toast.makeText(Normal_Course.this,"Data inserted",Toast.LENGTH_SHORT).show();

                }
                else if(semester.equals("Semester3"))
                {
                    subjectsSem3.add(new SubjectDetails(course,attendence_weightage,course_credit,ca_weightage,mte_weightage,ete_weightage,total_marks,Grade,gpa));
                    mref.child("Subjects").setValue(subjectsSem3);

                    Toast.makeText(Normal_Course.this,"Data inserted",Toast.LENGTH_SHORT).show();

                }
                else if(semester.equals("Semester4"))
                {
                    subjectsSem4.add(new SubjectDetails(course,attendence_weightage,course_credit,ca_weightage,mte_weightage,ete_weightage,total_marks,Grade,gpa));
                    mref.child("Subjects").setValue(subjectsSem4);

                    Toast.makeText(Normal_Course.this,"Data inserted",Toast.LENGTH_SHORT).show();

                }
                else if(semester.equals("Semester5"))
                {
                    subjectsSem5.add(new SubjectDetails(course,attendence_weightage,course_credit,ca_weightage,mte_weightage,ete_weightage,total_marks,Grade,gpa));
                    mref.child("Subjects").setValue(subjectsSem5);

                    Toast.makeText(Normal_Course.this,"Data inserted",Toast.LENGTH_SHORT).show();

                }
                else if(semester.equals("Semester6"))
                {
                    subjectsSem6.add(new SubjectDetails(course,attendence_weightage,course_credit,ca_weightage,mte_weightage,ete_weightage,total_marks,Grade,gpa));
                    mref.child("Subjects").setValue(subjectsSem6);

                    Toast.makeText(Normal_Course.this,"Data inserted",Toast.LENGTH_SHORT).show();

                }
                else if(semester.equals("Semester7"))
                {
                    subjectsSem7.add(new SubjectDetails(course,attendence_weightage,course_credit,ca_weightage,mte_weightage,ete_weightage,total_marks,Grade,gpa));
                    mref.child("Subjects").setValue(subjectsSem7);

                    Toast.makeText(Normal_Course.this,"Data inserted",Toast.LENGTH_SHORT).show();

                }
                else if(semester.equals("Semester8"))
                {
                    subjectsSem8.add(new SubjectDetails(course,attendence_weightage,course_credit,ca_weightage,mte_weightage,ete_weightage,total_marks,Grade,gpa));
                    mref.child("Subjects").setValue(subjectsSem8);

                    Toast.makeText(Normal_Course.this,"Data inserted",Toast.LENGTH_SHORT).show();

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
