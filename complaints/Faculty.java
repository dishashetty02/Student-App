package com.example.complaints;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.SearchView;

public class Faculty extends AppCompatActivity {

    ImageView i1,i2,i3,i4,i5,i6,i7,i8,i9,i10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        ActionBar bar=getSupportActionBar();
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#036CDB"));
        bar.setBackgroundDrawable(colorDrawable);
        bar.setTitle("Faculty Cabins");
        i1=findViewById(R.id.lec1);
        i2=findViewById(R.id.lec2);
        i3=findViewById(R.id.lec3);
        i4=findViewById(R.id.lec4);
        i5=findViewById(R.id.lec5);
        i6=findViewById(R.id.lec6);
        i7=findViewById(R.id.lec7);
        i8=findViewById(R.id.lec8);
        i9=findViewById(R.id.lec9);
        i10=findViewById(R.id.lec10);
        i1.setImageResource(R.drawable.lec1);
        i2.setImageResource(R.drawable.lec2);
        i3.setImageResource(R.drawable.lec3);
        i4.setImageResource(R.drawable.lec4);
        i5.setImageResource(R.drawable.lec5);
        i6.setImageResource(R.drawable.lec6);
        i7.setImageResource(R.drawable.lec7);
        i8.setImageResource(R.drawable.lec8);
        i9.setImageResource(R.drawable.lec9);
        i10.setImageResource(R.drawable.lec10);
    }

}