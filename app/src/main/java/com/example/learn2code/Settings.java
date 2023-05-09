package com.example.learn2code;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learn2code.data.DBHandler;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Settings extends AppCompatActivity {
    Connection connect;
    String ConnectionResult="";
    @SuppressLint("NewApi")

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

    public void getTextFromSQL(View v) {
        TextView username = findViewById(R.id.username);

        try {
            DBHandler db = new DBHandler();
            connect = db.connection();
            Toast.makeText(this, db.ConnectionURL, Toast.LENGTH_LONG).show();
            if (connect != null) {
                String query="SELECT from learn2code_Users";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    username.setText(rs.getString(2));
                }
            }
            else {
                ConnectionResult="Check Connection";
            }
        } catch (Exception ex) {
            Log.e("Error:", ex.getMessage());

        }

    }
}