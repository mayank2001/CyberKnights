package com.hackathon.cyberknights.activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hackathon.cyberknights.R;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Objects;

public class dashboard extends AppCompatActivity {
    Button logout;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    DataSnapshot dataSnapshot;
    String TAG = "DashboardActivity";
public void report (View view){
   Intent intent = new Intent(dashboard.this, piechart.class);
    startActivity(intent);
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        firebaseAuth = FirebaseAuth.getInstance();

        final TextView totalBalance = findViewById(R.id.balanceGet);

        final TextView FullName = findViewById(R.id.Full_Name);

        final TextView userEmail = findViewById(R.id.userEmail);
        databaseReference  = FirebaseDatabase.getInstance().getReference();






        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d(TAG, "onDataChange: Fetch Success Data Exist");

                //getters
                String totalBaclans = Objects.requireNonNull(snapshot.child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid()).child("UserProfile").child("monthlyIncome").getValue()).toString();
                 totalBalance.setText(totalBaclans);

                 String userName = Objects.requireNonNull(snapshot.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("UserProfile").child("username").getValue()).toString();
                FullName.setText(userName);
                userEmail.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());







            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(dashboard.this, "Cannot Connect To Database4", Toast.LENGTH_SHORT).show();
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(dashboard.this, "Logout Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(dashboard.this,LoginActivity.class));
                finish();
            }
        });

        ListView myListView = findViewById(R.id.transactions);
        ArrayList<String> transactionlist = new ArrayList<String>();
        transactionlist.add("Shopping = 5000Rs");
        transactionlist.add("Miscellaneous = 2000Rs");
        transactionlist.add("Food = 1500Rs");
        transactionlist.add("Others = 500Rs");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,transactionlist);
        myListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();


    }



}