package com.example.passapon.getpostarduino2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.passapon.getpostarduino2.Fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentMainFragment, new MainFragment())
                    .commit();
        }



    } // Main Method
} // Main Class
