package com.example.learn2code;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.learn2code.data.XPDatabase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Leaderboard extends CommonMethods {

    FirebaseAuth auth;
    FirebaseUser user;
    Long xp;
    TextView currentPosition;
    TextView username1, username2, username3, username4, username5, username6, username7, username8, username9, username10;
    TextView xp1, xp2, xp3, xp4, xp5, xp6, xp7, xp8, xp9, xp10;
    ImageView profPic1, profPic2, profPic3, profPic4, profPic5, profPic6, profPic7, profPic8, profPic9, profPic10;
    String userId;
    DatabaseReference dataRef;
    private XPDatabase xphandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_leaderboard);
        getLayoutResource();
        FirebaseApp.initializeApp(this);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        userId = user.getUid();
        dataRef = FirebaseDatabase.getInstance().getReference("users").child(userId).child("xp");
        username1 = findViewById(R.id.username1);
        username2 = findViewById(R.id.username2);
        username3 = findViewById(R.id.username3);
        username4 = findViewById(R.id.username4);
        username5 = findViewById(R.id.username5);
        username6 = findViewById(R.id.username6);
        username7 = findViewById(R.id.username7);
        username8 = findViewById(R.id.username8);
        username9 = findViewById(R.id.username9);
        username10 = findViewById(R.id.username10);
        xp1 = findViewById(R.id.xp1);
        xp2 = findViewById(R.id.xp2);
        xp3 = findViewById(R.id.xp3);
        xp4 = findViewById(R.id.xp4);
        xp5 = findViewById(R.id.xp5);
        xp6 = findViewById(R.id.xp6);
        xp7 = findViewById(R.id.xp7);
        xp8 = findViewById(R.id.xp8);
        xp9 = findViewById(R.id.xp9);
        xp10 = findViewById(R.id.xp10);
        profPic1 = findViewById(R.id.profilePic1);
        profPic2 = findViewById(R.id.profilePic2);
        profPic3 = findViewById(R.id.profilePic3);
        profPic4 = findViewById(R.id.profilePic4);
        profPic5 = findViewById(R.id.profilePic5);
        profPic6 = findViewById(R.id.profilePic6);
        profPic7 = findViewById(R.id.profilePic7);
        profPic8 = findViewById(R.id.profilePic8);
        profPic9 = findViewById(R.id.profilePic9);
        profPic10 = findViewById(R.id.profilePic10);
        getXpData();
        findUsers();


    }

    private void findUsers() {
        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("users");
        Query query = usersRef.orderByChild("xp").limitToFirst(10); // get top 10 users

        query.addValueEventListener(new ValueEventListener() { // gets real time updates
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i = 10;
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    final int position = i;
                    String userKey = userSnapshot.getKey();
                    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(userKey);
                    userRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String displayName = snapshot.child("displayName").getValue(String.class);
                            long userXp = snapshot.child("xp").getValue(Long.class);
                            String userProfPic = snapshot.child("profilePicture").getValue(String.class);
                            int profPicInt = 0;
                            if (userProfPic != null) {
                                profPicInt = getResources().getIdentifier(userProfPic, "drawable", getPackageName());
                            }
                            if (profPicInt == 0) {
                                profPicInt = R.drawable.ic_baseline_cake_24;
                            }
                            displayUser(position, displayName, userXp, profPicInt);
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                    i--;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void displayUser(int position, String displayName, long userXp, int userProfPic) {
        switch (position) {
            case 1:
                username1.setText(displayName);
                xp1.setText(userXp + "xp");
                profPic1.setImageResource(userProfPic);
                break;
            case 2:
                username2.setText(displayName);
                xp2.setText(userXp + "xp");
                profPic2.setImageResource(userProfPic);
                break;
            case 3:
                username3.setText(displayName);
                xp3.setText(userXp + "xp");
                profPic3.setImageResource(userProfPic);
                break;
            case 4:
                username4.setText(displayName);
                xp4.setText(userXp + "xp");
                profPic4.setImageResource(userProfPic);
                break;
            case 5:
                username5.setText(displayName);
                xp5.setText(userXp + "xp");
                profPic5.setImageResource(userProfPic);
                break;
            case 6:
                username6.setText(displayName);
                xp6.setText(userXp + "xp");
                profPic6.setImageResource(userProfPic);
                break;
            case 7:
                username7.setText(displayName);
                xp7.setText(userXp + "xp");
                profPic7.setImageResource(userProfPic);
                break;
            case 8:
                username8.setText(displayName);
                xp8.setText(userXp + "xp");
                profPic8.setImageResource(userProfPic);
                break;
            case 9:
                username9.setText(displayName);
                xp9.setText(userXp + "xp");
                profPic9.setImageResource(userProfPic);
                break;
            case 10:
                username10.setText(displayName);
                xp10.setText(userXp + "xp");
                profPic10.setImageResource(userProfPic);
                break;
        }
    }

    private void getXpData() {
        if (user != null) {
            dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // Retrieve the "xp" value from the dataSnapshot
                    xp = dataSnapshot.getValue(Long.class);
                    displayXp();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(Leaderboard.this, "Failed to retrieve data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } if (xp == null) {
            xphandler = new XPDatabase(Leaderboard.this);
            xp = (long) xphandler.getXP("xp");
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