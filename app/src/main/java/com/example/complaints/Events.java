package com.example.complaints;


import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Events extends AppCompatActivity {

    String seldate;
    TextView title,venue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        ActionBar bar = getSupportActionBar();
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#036CDB"));
        bar.setBackgroundDrawable(colorDrawable);
        bar.setTitle("Events & Calendar");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        title=findViewById(R.id.title);
        venue=findViewById(R.id.venue);

        CalendarView d=findViewById(R.id.ev);
        Calendar date = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
        String curDate = sdf.format(date.getTime());
        db.collection("events").whereEqualTo("date",curDate)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()) {
                            if(task.getResult().isEmpty()){
                                title.setText("No events!!");
                                venue.setText("");
                            }
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                title.setText(document.getString("title"));
                                venue.setText(document.getString("venue"));
                            }
                        }
                    }
                });
        d.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView arg0, int year, int month, int date) {
                seldate=date+"/"+(month+1)+"/"+year;
                db.collection("events").whereEqualTo("date",seldate)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if(task.isSuccessful()) {
                                    if(task.getResult().isEmpty()){
                                        title.setText("No events!!");
                                        venue.setText("");
                                    }
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        title.setText(document.getString("title"));
                                        venue.setText(document.getString("venue"));
                                    }
                                }
                            }
                        });
            }
        });


    }
}