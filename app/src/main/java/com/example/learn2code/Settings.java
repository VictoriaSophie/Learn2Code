package com.example.learn2code;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.sql.Connection;

//import DBHandler;


public class Settings extends CommonMethods {
//    Connection connect;
//    String ConnectionResult="";

    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        EditText usernameEt = findViewById(R.id.editUsername);
        Button changeName = findViewById(R.id.usernameButton);

        TextView username = findViewById(R.id.username);
        Button logoutButton = findViewById(R.id.logoutButton);
        Button loginButton = findViewById(R.id.loginButton);

        Button profilePicBtn = findViewById(R.id.changeProfPic);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        GoogleSignInClient gsc = GoogleSignIn.getClient(this, gso);

        if (user!=null){
            username.setText(user.getDisplayName());
        }


        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!=null) {
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
                }
                else {
                    if (user != null) {
                        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(usernameText).build();
                        assert user != null;
                        user.updateProfile(profileUpdates);
                        // reload page
                        finish();
                        Intent intent = new Intent(getApplicationContext(), Settings.class);
                        startActivity(intent);
                    } else if (acct != null) {
                        Toast.makeText(Settings.this, "Please change display name on your google account.", Toast.LENGTH_LONG).show();

                    }
                    else {
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
                }
                else if (acct != null){
                    signOut(gsc);
                }
                else {
                    Toast.makeText(Settings.this, "You are already signed out.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        profilePicBtn.setOnClickListener(v -> startActivity(new Intent(Settings.this, ProfilePicture.class)));
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