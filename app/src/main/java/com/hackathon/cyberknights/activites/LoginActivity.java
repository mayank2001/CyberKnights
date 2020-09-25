package com.hackathon.cyberknights.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hackathon.cyberknights.R;
public class LoginActivity extends AppCompatActivity {

    EditText txtEmail,txtPassword;
    Button get_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmail=(EditText)findViewById(R.id.user_name);
        txtPassword=(EditText)findViewById(R.id.Pass_word);
        get_otp = (Button) findViewById(R.id.get_otp);


        get_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {








            }
        });




    }
}