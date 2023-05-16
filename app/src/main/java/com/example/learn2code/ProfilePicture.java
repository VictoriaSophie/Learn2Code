package com.example.learn2code;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfilePicture extends CommonMethods {

    Button blueButton, tealButton, whiteButton, blackButton, saveChanges;
    ImageView cookieIcon, bunnyIcon, cakeIcon, fireIcon, curlyIcon, straightIcon, baldIcon, hairIcon, currentPic;
    String currentPicRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutResource();

        blueButton = findViewById(R.id.blueButton);
        tealButton = findViewById(R.id.tealButton);
        whiteButton = findViewById(R.id.whiteButton);
        blackButton = findViewById(R.id.blackButton);
        cookieIcon = findViewById(R.id.cookieIcon);
        bunnyIcon = findViewById(R.id.bunnyIcon);
        cakeIcon = findViewById(R.id.cakeIcon);
        fireIcon = findViewById(R.id.fireIcon);
        curlyIcon = findViewById(R.id.curlyIcon);
        straightIcon = findViewById(R.id.straightIcon);
        baldIcon = findViewById(R.id.baldIcon);
        hairIcon = findViewById(R.id.hairIcon);
        currentPic = findViewById(R.id.currentPic);

        blueButton.setOnClickListener(clickListener);
        tealButton.setOnClickListener(clickListener);
        whiteButton.setOnClickListener(clickListener);
        blackButton.setOnClickListener(clickListener);
        cookieIcon.setOnClickListener(clickListener);
        bunnyIcon.setOnClickListener(clickListener);
        cakeIcon.setOnClickListener(clickListener);
        fireIcon.setOnClickListener(clickListener);
        curlyIcon.setOnClickListener(clickListener);
        straightIcon.setOnClickListener(clickListener);
        baldIcon.setOnClickListener(clickListener);
        hairIcon.setOnClickListener(clickListener);

        saveChanges = findViewById(R.id.saveChanges);
        currentPicRes = "R.drawable.ic_baseline_cookie_24";

        saveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()); // get user uid
                userRef.child("profilePicture").setValue(currentPicRes);
//                Uri path = Uri.parse(currentPicRes);
//                String imgPath = path.toString();
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setPhotoUri(Uri.parse(imgPath)).build();
//                assert user != null;
//                user.updateProfile(profileUpdates);

                Intent intent = new Intent(getApplicationContext(), Settings.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public int getLayoutResource() {
        return R.layout.activity_profile_picture;
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

    View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.blueButton:
                    currentPic.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.purple_500));
                    break;
                case R.id.tealButton:
                    currentPic.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.teal_200));
                    break;
                case R.id.whiteButton:
                    currentPic.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    break;
                case R.id.blackButton:
                    currentPic.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    break;
                    // images
                case R.id.cookieIcon:
                    currentPic.setImageResource(R.drawable.ic_baseline_cookie_24);
                    currentPicRes = "ic_baseline_cookie_24";
                    break;
                case R.id.bunnyIcon:
                    currentPic.setImageResource(R.drawable.ic_baseline_cruelty_free_24);
                    currentPicRes = "ic_baseline_cruelty_free_24";
                    break;
                case R.id.cakeIcon:
                    currentPic.setImageResource(R.drawable.ic_baseline_cake_24);
                    currentPicRes = "ic_baseline_cake_24";
                    break;
                case R.id.fireIcon:
                    currentPic.setImageResource(R.drawable.ic_baseline_whatshot_24);
                    currentPicRes = "ic_baseline_whatshot_24";
                    break;
                case R.id.curlyIcon:
                    currentPic.setImageResource(R.drawable.ic_baseline_face_2);
                    currentPicRes = "ic_baseline_face_2";
                    break;
                case R.id.straightIcon:
                    currentPic.setImageResource(R.drawable.ic_baseline_face_3_24);
                    currentPicRes = "ic_baseline_face_3_24";
                    break;
                case R.id.baldIcon:
                    currentPic.setImageResource(R.drawable.ic_baseline_face_5_24);
                    currentPicRes = "ic_baseline_face_5_24";
                    break;
                case R.id.hairIcon:
                    currentPic.setImageResource(R.drawable.ic_baseline_face_6_24);
                    currentPicRes = "ic_baseline_face_6_24";
                    break;

            }
        }
    };
}