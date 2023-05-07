package com.example.complaints;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class Timetable extends AppCompatActivity {

    ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#F97B22"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        ActionBar bar=getSupportActionBar();
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#036CDB"));
        bar.setBackgroundDrawable(colorDrawable);
        bar.setTitle("Timetable");
        ImageView i1,i2,i3,i4;
        i1=findViewById(R.id.aimage);
        i2=findViewById(R.id.bimage);
        i3=findViewById(R.id.cimage);
        i4=findViewById(R.id.dimage);
        i1.setImageResource(R.drawable.asection);
        i2.setImageResource(R.drawable.bsection);
        i3.setImageResource(R.drawable.csection);
        i4.setImageResource(R.drawable.dsection);
    }

}