package com.example.GymGuide;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.cgpacalculator.R;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Protien_Activity extends AppCompatActivity {
//TextView protien_text;
    RecyclerView protein_recyclerview;
    Toolbar protien_toolbar;
    ImageView protein_main_image;

   // private ArrayList<Integer> Protein_Image=new ArrayList<>();

    String pn[] ={"Muscleblaze Raw Whey Protein","Labrada Muscle Mass Gainer","Ultimate Nutrition Prostar","Big Muscles Signature","Dymatize Elite"};
    int[] protein_img = {R.drawable.protein15,R.drawable.protein5,R.drawable.protein6,R.drawable.protein8,R.drawable.prot100};
    String[] protein_weiht_array = {"2.2 lb/kg","2.2 lb/kg","5.5 lb/kg","2.3 lb/kg","1.1 lb/kg"};
    String[] descrption_protien = {"This is for fitness enthusiasts,Maximises muscle growth and speeds up recovery after workouts","It helps to increase strength and workout performance and helps in rapid recovery from muscle fatigue"
            ,"Each Serving of 32g contains 25g PROTEIN, 5.5g BCAAS and 4g GLUTAMIC ACID which makes the blend higly effective for Muscle Gain and Synthesis",
            "The new MuscleBlaze Whey Gold Rich Milk Chocolate available in all new packaging with enhance formulation to deliver.It provides 25g of pure Whey Protein Isolate per serving"
            ,"This Protein provides 1.35g of dietary fiber and contains No Added Sugar and Trans Fats"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protien_);
        //protien_text=findViewById(R.id.protien_text);

       /* protien_toolbar=findViewById(R.id.protien_toolbar);
        protien_toolbar.setTitle("Protein List");
        setSupportActionBar(protien_toolbar);*/


        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        actionBar.setTitle("Protein List");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2A3c58")));


        protein_main_image=findViewById(R.id.protein_main_image);
        protein_main_image.setImageResource(R.drawable.protein_main2);

        protein_recyclerview=findViewById(R.id.protein_recyclerview);
        protein_recyclerview.setHasFixedSize(true);

        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        protein_recyclerview.setLayoutManager(layoutManager4);
      //  getData3();
        Protein_Adapter adapter5=new Protein_Adapter(this,protein_img,pn,protein_weiht_array,descrption_protien);
        protein_recyclerview.setAdapter(adapter5);

    }
   // private void getData3() {

       // Protein_Image.add(R.drawable.abs);



  //  }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
