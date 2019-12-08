package com.example.GymGuide;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cgpacalculator.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Membership_Activity extends AppCompatActivity {
    Toolbar membership_toolbar;
    ImageView member_image1,member_image2;
    RecyclerView membership_recyclerview;
RelativeLayout viewid;


    TextView mtq1,mtq2,mtq3,mtq4,mtq5,click_text;
    String s1="To join you must be 16 years old and above. We will only entertain members under 16 if they are obese, are under doctor advisement and take up personal training. All membership agreements for children under 16 years of age need to be authorised and signed by a legal guardian.";
    String s2="Membership rates vary depending on the type of package that is best suited for you. Please contact your preferred Fitness First club where our staff will be happy to discuss the various membership options available";
    String s3="Yes you can. We call our hold option - freeze. At Fitness First, we believe that exercise is a lifelong habit. That's why when it comes to freezing of your membership, it will only be for medical reasons or outstation / overseas assignments for more than 2 weeks with written notice. For further information, please go to nearest Gym. A freeze fee will be charged.";
    String s4="We hope you have really benefited from your time with us. However if you have to cancel your membership, please visit your nearest Gym where one of our receptionists will arrange someone to take you through the cancellation procedure.";
    String s5="No. However, if you wish to maximise results with minimum time, we also offer Personal Training and Nutrition Counseling sessions as well as certain special paid Group Training workouts.";
    private ArrayList<Integer> membership_facility_img=new ArrayList<>();
    private ArrayList<String> membership_facility_text=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_membership_);


        getSupportActionBar().setTitle("About Membership");

        member_image1=findViewById(R.id.membership_image1);
        member_image2=findViewById(R.id.membership_image2);

        member_image1.setImageResource(R.drawable.membership_image1);
        member_image2.setImageResource(R.drawable.membership_image2);

        membership_recyclerview=findViewById(R.id.membership_recyclerview);
        membership_recyclerview.setHasFixedSize(true);

        GridLayoutManager layoutManager1 = new GridLayoutManager(this,2, LinearLayoutManager.HORIZONTAL,false);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);

        membership_recyclerview.setLayoutManager(layoutManager1);
        getData3();
        Membership_Adapter adapter5=new Membership_Adapter(this,membership_facility_img,membership_facility_text);
        membership_recyclerview.setAdapter(adapter5);

        mtq1=findViewById(R.id.mtq1);
        mtq2=findViewById(R.id.mtq2);
        mtq3=findViewById(R.id.mtq3);
        mtq4=findViewById(R.id.mtq4);
        mtq5=findViewById(R.id.mtq5);
        click_text=findViewById(R.id.click_text);

        mtq1.setText("How old Should I be to join Gym ?");
        mtq2.setText("How much is membership at Gym ?");
        mtq3.setText("Can I put my membership on hold ?");
        mtq4.setText("What if I want to cancel my Membership ?");
        mtq5.setText("Are there extra to pay for once I’ve joined Gym ?");

        switch (R.id.mtq1)
        {
            case R.id.mtq1: mtq1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click_text.setText(s1);
                }
            });

            case R.id.mtq2: mtq2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click_text.setText(s2);
                }
            });

            case R.id.mtq3: mtq3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click_text.setText(s3);
                }
            });

            case R.id.mtq4: mtq4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click_text.setText(s4);
                }
            });

            case R.id.mtq5: mtq5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click_text.setText(s5);
                }
            });
        }

    }
    private void getData3()
    {
        membership_facility_img.add(R.drawable.f1);
        membership_facility_text.add("Group Exercise");

        membership_facility_img.add(R.drawable.f2);
        membership_facility_text.add("Gym Floor");

        membership_facility_img.add(R.drawable.f3);
        membership_facility_text.add("Cardio Area");

        membership_facility_img.add(R.drawable.f4);
        membership_facility_text.add("Cycle Studio");

        membership_facility_img.add(R.drawable.f5);
        membership_facility_text.add("Free Weights");

        membership_facility_img.add(R.drawable.f6);
        membership_facility_text.add("Free Style");

        membership_facility_img.add(R.drawable.f7);
        membership_facility_text.add("WiFi");

        membership_facility_img.add(R.drawable.f8);
        membership_facility_text.add("Shower Area");

        membership_facility_img.add(R.drawable.f9);
        membership_facility_text.add("Steam Room");

        membership_facility_img.add(R.drawable.f10);
        membership_facility_text.add("Personal Training");
    }
}
