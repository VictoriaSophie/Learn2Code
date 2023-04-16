//package com.example.learn2code;
//
//import android.content.Context;
//import android.content.Intent;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.Toast;
//import android.widget.Toolbar;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomappbar.BottomAppBar;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//public class Menu extends AppCompatActivity {
//
//
//    @Override
//    public boolean onCreateOptionsMenu(android.view.Menu menu) {
//        BottomAppBar bottomAppBar;
//        FloatingActionButton home_button;
//
//        bottomAppBar=findViewById(R.id.bottomAppBar2);
//        home_button=findViewById(R.id.home);
//
//
//        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                if (item.getItemId()==R.id.settings)
//                {
//                    Toast settingsToast = Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT);
//                    settingsToast.show();
//                    //Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
//                }
//                return true;
//            }
//        });
//        home_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//            }
//        });
//
//        return true;
//    }
//
//
//}
