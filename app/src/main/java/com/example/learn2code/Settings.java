package com.example.learn2code;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.sql.Connection;

//import DBHandler;


public class Settings extends CommonMethods {
    Connection connect;
    String ConnectionResult="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

//        TextView username = findViewById(R.id.username);
        Button logoutButton = findViewById(R.id.logoutButton);


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        GoogleSignInClient gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if (acct!=null) {
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
//            username.setText(personName);
        }

        logoutButton.setOnClickListener(view -> signOut(gsc));
    }

    private void signOut(GoogleSignInClient gsc) {
        gsc.signOut().addOnCompleteListener(task -> {
            finish();
            startActivity(new Intent(Settings.this, LogIn.class));
        });
    }

//    public void getTextFromSQL(View v) {
//        TextView username = findViewById(R.id.username);
//
//        try {
//            DBHandler db = new DBHandler();
//            connect = db.connection();
//            Toast.makeText(this, db.ConnectionURL, Toast.LENGTH_LONG).show();
//            if (connect != null) {
//                String query="SELECT from learn2code_Users";
//                Statement st = connect.createStatement();
//                ResultSet rs = st.executeQuery(query);
//                while (rs.next()) {
//                    username.setText(rs.getString(2));
//                }
//            }
//            else {
//                ConnectionResult="Check Connection";
//            }
//        } catch (Exception ex) {
//            Log.e("Error:", ex.getMessage());
//
//        }
//
//    }

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