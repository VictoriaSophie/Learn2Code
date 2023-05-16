package com.example.learn2code;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.learn2code.data.XPDatabase;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Settings extends CommonMethods {

    FirebaseAuth auth;
    FirebaseUser user;
    private XPDatabase xphandler;
    String newUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        FirebaseApp.initializeApp(this);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        ImageView profilePicture = findViewById(R.id.profilePicture);
        profilePicture.setImageDrawable(null);
        EditText usernameEt = findViewById(R.id.editUsername);
        Button changeName = findViewById(R.id.usernameButton);

        TextView username = findViewById(R.id.username);
        Button logoutButton = findViewById(R.id.logoutButton);
        Button loginButton = findViewById(R.id.loginButton);

        Button profilePicBtn = findViewById(R.id.changeProfPic);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        GoogleSignInClient gsc = GoogleSignIn.getClient(this, gso);

        xphandler = new XPDatabase(Settings.this);
        TextView xpText = findViewById(R.id.xpText);

        int xp = xphandler.getXP("xp"); // get current xp value
        xpText.setText(xp + "xp");

        if (user != null) {
            String userId = user.getUid();
            DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference("users").child(userId).child("displayName");
            dataRef.addValueEventListener(new ValueEventListener() { // gets real time updates
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        newUserName = dataSnapshot.getValue(String.class);
                        username.setText(newUserName);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
//
//            username.setText(user.getDisplayName()); // need to change to child displayName
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String profilePicText = snapshot.child("profilePicture").getValue(String.class);
                    if (profilePicText !=null) {
                        int profPicInt = getResources().getIdentifier(profilePicText, "drawable", getPackageName());
                        if (profPicInt != 0) {
                            profilePicture.setImageResource(profPicInt);
                        }
                    } else {
                        profilePicture.setImageResource(R.drawable.ic_baseline_whatshot_24);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            String personName = acct.getDisplayName();
//            String personEmail = acct.getEmail();
            username.setText(personName);
        }

        changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameText = String.valueOf(usernameEt.getText());
                if (TextUtils.isEmpty(usernameText)) {
                    Toast.makeText(Settings.this, "Please enter a new username", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null) {
                        String userId = user.getUid();
                        DatabaseReference dataRef = FirebaseDatabase.getInstance().getReference("users").child(userId).child("displayName");
                        dataRef.setValue(usernameText)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        username.setText(usernameText);
                                        Toast.makeText(Settings.this, "Updated username successfully", Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Settings.this, "Error updating username, please try again later.", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    } else if (acct != null) {
                        Toast.makeText(Settings.this, "Please change display name on your google account.", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Settings.this, "Something went wrong.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Settings.this, LogIn.class));
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user != null) {
                    FirebaseAuth.getInstance().signOut();
                } else if (acct != null) {
                    signOut(gsc);
                } else {
                    Toast.makeText(Settings.this, "You are already signed out.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        profilePicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getApplicationContext(), ProfilePicture.class);
                startActivity(intent);
            }
        });
    }

    private void signOut(GoogleSignInClient gsc) {
        gsc.signOut().addOnCompleteListener(task -> {
            finish();
            startActivity(new Intent(Settings.this, LogIn.class));
        });
    }


    @Override
    protected int getLayoutResource() {
        return R.layout.activity_settings;
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