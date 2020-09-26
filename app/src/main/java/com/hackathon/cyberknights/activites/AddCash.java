package com.hackathon.cyberknights.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hackathon.cyberknights.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddCash extends AppCompatActivity {

    //define buttons , texts


    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cash);

        //database
        databaseReference  = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();



        //make one arraylist
        //set adapter to the list

        ArrayList<String> transactionlist = new ArrayList<String>();
         transactionlist.add("Shopping");
         transactionlist.add("Miscellaneous");
         transactionlist.add("Food");
         transactionlist.add("");



















    }




}