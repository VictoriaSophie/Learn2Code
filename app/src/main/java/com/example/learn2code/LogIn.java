package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        TextView email = findViewById(R.id.email);
        TextView password = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener(view -> {
            if(email.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                Toast.makeText(LogIn.this, "Correct email and password", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(LogIn.this, "Wrong", Toast.LENGTH_SHORT).show();
            }
        });

        registerButton.setOnClickListener(view -> startActivity(new Intent(LogIn.this, Register.class)));
    }
}