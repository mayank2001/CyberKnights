package com.hackathon.cyberknights.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.hackathon.cyberknights.R;

public class setbudget extends AppCompatActivity {

    EditText editText;

    public void  setBudget(View view) {
         Intent intent = new Intent(setbudget.this, com.hackathon.cyberknights.basic.dashboard.class );

         startActivity(intent);





    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_budget);


        editText = (EditText) findViewById(R.id.setBudget);
    }
}