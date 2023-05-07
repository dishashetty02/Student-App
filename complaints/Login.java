package com.example.complaints;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText Username, Password, Name, USN;
    Button btnLogin;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Name = findViewById(R.id.Name);
        USN = findViewById(R.id.USN);
        Username = findViewById(R.id.Username);
        Password = findViewById(R.id.Password);
        btnLogin = findViewById(R.id.btn_login);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformAuth();
            }

            private void PerformAuth() {
                String name = Name.getText().toString();
                String usn = USN.getText().toString();
                String username = Username.getText().toString();
                String password = Password.getText().toString();
                mAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Intent intent=new Intent(Login.this,Dashboard.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra("name", name);
                            intent.putExtra("usn", usn);
                            startActivity(intent);
                            Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(Login.this, "User not registered", Toast.LENGTH_SHORT).show();
                        }}
                });
            }
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

}

//IN DASHBOARD
//String name = getIntent().getStringExtra("name");
//String usn = getIntent().getStringExtra("usn")