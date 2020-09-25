package com.hackathon.cyberknights.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.hackathon.cyberknights.MainActivity;
import com.hackathon.cyberknights.R;
public class SignupActivity extends AppCompatActivity {
    EditText txtName, txtemail, txtPassword, txtMonthlyIncome, txtDOB;
    Button btn_Continue;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("Sign Up Form");

        txtemail = (EditText) findViewById(R.id.email_add);
        txtPassword = (EditText) findViewById(R.id.password);
        txtDOB = (EditText) findViewById(R.id.date_birth);
        txtName = (EditText) findViewById(R.id.Name);
        txtMonthlyIncome = (EditText) findViewById(R.id.month_income);

        firebaseAuth = FirebaseAuth.getInstance();


        btn_Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txtemail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String DOB = txtDOB.getText().toString().trim();
                String Name = txtName.getText(
                ).toString().trim();
                String Monthly = txtMonthlyIncome.getText().toString().trim();

                if ((TextUtils.isEmpty(email))) {
                    Toast.makeText(getApplicationContext(), "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if ((TextUtils.isEmpty(password))) {
                    Toast.makeText(getApplicationContext(), "Please Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ((TextUtils.isEmpty(DOB))) {
                    Toast.makeText(getApplicationContext(), "Please Enter Date of Birth", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ((TextUtils.isEmpty(Name))) {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ((TextUtils.isEmpty(Monthly))) {
                    Toast.makeText(getApplicationContext(), "Please Enter Your Income", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short", Toast.LENGTH_SHORT).show();
                }

                if (password.equals(password)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {


                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                        Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }

                                }

                            });
                }


            }

            ;
        });
    }
}