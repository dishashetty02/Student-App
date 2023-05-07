package com.example.complaints;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        TextView bus=findViewById(R.id.textView8);
        TextView name1=findViewById(R.id.textView);
        TextView usn1=findViewById(R.id.textView2);
        TextView faculty=findViewById(R.id.textView7);
        TextView events=findViewById(R.id.textView6);
        TextView timetable=findViewById(R.id.textView5);
        TextView contacts=findViewById(R.id.textView9);
        TextView attendance=findViewById(R.id.textView4);

        String name = getIntent().getStringExtra("name");
        String usn = getIntent().getStringExtra("usn");

        name1.setText(name);
        usn1.setText(usn);

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Buses.class);
                startActivity(i);
            }
        });
        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Faculty.class);
                startActivity(i);
            }
        });
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Attendance.class);
                startActivity(i);
            }
        });timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Timetable.class);
                startActivity(i);
            }
        });events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Events.class);
                startActivity(i);
            }
        });contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Dashboard.this,Contacts.class);
                startActivity(i);
            }
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}