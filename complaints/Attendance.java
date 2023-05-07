package com.example.complaints;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Attendance extends AppCompatActivity {


    private DatabaseReference mDatabaseReference;
    //private FirebaseUser mUser;
    private String mName, mUsn;
    private TextView mNameTextView, mUsnTextView, mAttendanceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        ActionBar bar=getSupportActionBar();
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#036CDB"));
        bar.setBackgroundDrawable(colorDrawable);
        bar.setTitle("Attendance");
        mNameTextView = findViewById(R.id.nameTextView);
        mUsnTextView = findViewById(R.id.usnTextView);
        mAttendanceTextView = findViewById(R.id.attendanceTextView);

        //mUser = FirebaseAuth.getInstance().getCurrentUser(); //  fetchs user id
        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("attendence");

        mName = getIntent().getStringExtra("name");
        mUsn = getIntent().getStringExtra("usn");

        mDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(mUsn)) {
                    String cg = dataSnapshot.child(mUsn).child("CG").getValue().toString();
                    String cn = dataSnapshot.child(mUsn).child("CN").getValue().toString();
                    String ml = dataSnapshot.child(mUsn).child("ML").getValue().toString();
                    String mad = dataSnapshot.child(mUsn).child("MAD").getValue().toString();
                    String cc = dataSnapshot.child(mUsn).child("CC").getValue().toString();

                    mNameTextView.setText(mName);
                    mUsnTextView.setText(mUsn);
                    mAttendanceTextView.setText("CG: " + cg + "\nCN: " + cn + "\nML: " + ml + "\nMAD: " + mad + "\nCC: " + cc);
                } else {
                    Toast.makeText(Attendance.this, "No attendance data found for " + mUsn, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Attendance.this, "Error fetching attendance data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}