package com.example.learn2code;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // check if user is signed in
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
        if (currentUser!= null) {
            Intent intent = new Intent(getApplicationContext(), Settings.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        socialMediaAccLinks();

        mAuth = FirebaseAuth.getInstance();

        EditText emailEt = findViewById(R.id.email);
        EditText passwordEt = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener(view -> {
//              signIn(email, password);
            String emailText = String.valueOf(emailEt.getText());
            String passwordText = String.valueOf(passwordEt.getText());
            if (TextUtils.isEmpty(emailText)){
                Toast.makeText(LogIn.this, "Please enter email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(emailText)){
                Toast.makeText(LogIn.this, "Please enter password", Toast.LENGTH_SHORT).show();
                return;
            }

            mAuth.signInWithEmailAndPassword(emailText, passwordText)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), Settings.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(LogIn.this, "Authentication failed", Toast.LENGTH_LONG).show();

                            }

                            // ...
                        }
                    });



//            if(email.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
//                Toast.makeText(LogIn.this, "Correct email and password", Toast.LENGTH_SHORT).show();
//            }
//            else{
//                Toast.makeText(LogIn.this, "Wrong", Toast.LENGTH_SHORT).show();
//            }
        });

        registerButton.setOnClickListener(view -> startActivity(new Intent(LogIn.this, Register.class)));
    }

//    private void signIn(String email, String password) {
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            userInfo(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithEmail:failure", task.getException());
//                            Toast.makeText(LogIn.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            userInfo(null);
//                        }
//
//                        // ...
//                    }
//                });
//    }

    private void userInfo(FirebaseUser user) {
//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();
            Toast.makeText(LogIn.this, name + " " + email, Toast.LENGTH_LONG).show();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }
        else {
            Toast.makeText(this, "user is null", Toast.LENGTH_SHORT).show();
        }

    }

    // to-do: set up so confirm button comes up to ask user to confirm username etc and change if they want if first time using google sign in
    private void socialMediaAccLinks() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        GoogleSignInClient gsc = GoogleSignIn.getClient(this, gso);
        ImageView googleButton = findViewById(R.id.googleButton);

        googleButton.setOnClickListener(view -> gSignIn(gsc));
    }

    private void gSignIn(GoogleSignInClient gsc) {
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Something went wrong, please try again.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void navigateToSecondActivity() {
        finish();
        Intent intent = new Intent(LogIn.this, Settings.class);
        startActivity(intent);
    }
}