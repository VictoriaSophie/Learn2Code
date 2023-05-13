package com.example.learn2code;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Register extends AppCompatActivity {

//    DBHandler usersDB;
    EditText usernameEt, emailEt, passwordEt;
    Button registerButton, logInButton;
    FirebaseAuth mAuth;

//    @Override
//    public void onStart() {
//        super.onStart();
//        // check if user is signed in
//        FirebaseUser currentUser = mAuth.getCurrentUser();
////        updateUI(currentUser);
//        if (currentUser!= null) {
//            Intent intent = new Intent(getApplicationContext(), Settings.class);
//            startActivity(intent);
//            finish();
//        }
//    }

    String usernameText, emailText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        logInButton =findViewById(R.id.loginButton);
        usernameEt = findViewById(R.id.username);
        emailEt = findViewById(R.id.email);
        passwordEt = findViewById(R.id.password);
        registerButton = findViewById(R.id.createAccButton);
        mAuth = FirebaseAuth.getInstance();

        logInButton.setOnClickListener(v -> startActivity(new Intent(Register.this, LogIn.class)));

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usernameText = String.valueOf(usernameEt.getText());
                emailText = String.valueOf(emailEt.getText());
                passwordText = String.valueOf(passwordEt.getText());
                if (TextUtils.isEmpty(emailText)){
                    Toast.makeText(Register.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passwordText)){
                    Toast.makeText(Register.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(usernameText)) {
                    Toast.makeText(Register.this, "Please enter username", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!usernameText.isEmpty()) {
                    mAuth.createUserWithEmailAndPassword(emailText, passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(Register.this, "Account created.", Toast.LENGTH_SHORT).show();
                                setUsername();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(Register.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }

    private void setUsername() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(usernameText).build();
        assert user != null;
        user.updateProfile(profileUpdates);
        Intent intent = new Intent(getApplicationContext(), Settings.class);
        startActivity(intent);
        finish();

    }

}