package com.example.learn2code;

import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learn2code.data.XPDatabase;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Leaderboard extends CommonMethods {

    FirebaseAuth auth;
    FirebaseUser user;
    Long xp;
    TextView currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_leaderboard);
        getLayoutResource();
        FirebaseApp.initializeApp(this);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        getXpData();


    }

    private void getXpData() {
        String userId = user.getUid();
        DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference("users").child(userId).child("xp");
        if (user != null) {
            dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Retrieve the "xp" value from the dataSnapshot
                    xp = dataSnapshot.getValue(Long.class);
                    displayXp();

                    // Display the retrieved data
//                    Toast.makeText(StandardQuiz.this, "User: " + userName + ", XP: " + userXP, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Handle the error, if any
//                    Toast.makeText(StandardQuiz.this, "Failed to retrieve data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            xp = (long) XPDatabase.getXP("xp");
            displayXp();
        }

    }

    private void displayXp() {
        currentPosition = findViewById(R.id.currentText);
        currentPosition.setText("xp: " + xp);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_leaderboard;
    }

    @Override
    public boolean onCreateOptionsMenu() {
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}