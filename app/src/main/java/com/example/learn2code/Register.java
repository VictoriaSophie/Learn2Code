package com.example.learn2code;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learn2code.data.DBHandler;

public class Register extends AppCompatActivity {

    DBHandler usersDB;
    EditText usernameEt, emailEt;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEt = findViewById(R.id.username);
        emailEt = findViewById(R.id.email);
        registerButton = findViewById(R.id.createAccButton);

//        registerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String usernameText = username.getText().toString();
//                Toast.makeText(Register.this, "Username is "+usernameText, Toast.LENGTH_SHORT).show();
//            }
//        });

//        usersDB = new DBHandler(this);

    }
//
//    public void addData(){
//        registerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username = usernameEt.getText().toString();
//                String email = emailEt.getText().toString();
//
//                boolean insertData = usersDB.addData(username, email);
//                if (insertData) {
//                    Toast.makeText(Register.this, "User successfully created!", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(Register.this, "Something went wrong, please try again later.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
}