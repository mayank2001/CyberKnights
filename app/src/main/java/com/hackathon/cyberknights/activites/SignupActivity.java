package com.hackathon.cyberknights.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hackathon.cyberknights.MainActivity;
import com.hackathon.cyberknights.R;
import com.hackathon.cyberknights.models.UserCostReqModel;

import java.util.Objects;

public class SignupActivity extends AppCompatActivity {
    EditText txtName, txtemail, txtPassword, txtMonthlyIncome, txtDOB;
    Button btn_Continue;
    private FirebaseAuth firebaseAuth;
    SharedPreferences prefs;
    SharedPreferences.Editor editor ;
    DatabaseReference mdatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //getSupportActionBar().setTitle("Sign Up Form");

        txtemail = (EditText) findViewById(R.id.email_add);
        txtPassword = (EditText) findViewById(R.id.password);
        txtDOB = (EditText) findViewById(R.id.date_birth);
        txtName = (EditText) findViewById(R.id.name);
        txtMonthlyIncome = (EditText) findViewById(R.id.month_income);
        mdatabaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();


        (findViewById(R.id.cont)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = txtemail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String DOB = txtDOB.getText().toString().trim();
                String Name = txtName.getText().toString().trim();
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
                    Log.d("Login In After Pas", ""+email+password);
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {


                                    if (!task.isSuccessful()) {


                                        Toast.makeText(getApplicationContext(), "User False", Toast.LENGTH_SHORT).show();
                                    } else {
                                        startActivity(new Intent(getApplicationContext(), dashboard.class));
                                        sendExDataToFb();
                                        Toast.makeText(getApplicationContext(), "Authentication True", Toast.LENGTH_SHORT).show();
                                    }

                                }

                            });
                }


            }

        });

    }
    private void sendExDataToFb(){


        //for sending data to firebase with specific user id

        String email =  txtemail.getText().toString().trim();
        String monthlyIncome = txtMonthlyIncome.getText().toString();
        String dob = txtDOB.getText().toString();


        UserCostReqModel userCostReqModel = new UserCostReqModel(email,monthlyIncome,dob);
        mdatabaseReference.child(Objects.requireNonNull(firebaseAuth.getCurrentUser()).getUid()).child("UserProfile").setValue(userCostReqModel);




    }
}