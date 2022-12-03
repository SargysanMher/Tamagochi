package com.example.tamagochi;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button start,settings;

int diff;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start);

        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            diff = 0;
        } else {
            diff = extras.getInt("DIFF");
        }


        settings = findViewById(R.id.settings);
        start.setOnClickListener(view -> {
            Intent intent;
            if(diff==0){
                intent = new Intent(MainActivity.this, MainActivity2.class);
                finish();
            }
            else{
                intent = new Intent(MainActivity.this, MainActivity3.class);
                finish();
            }
            startActivity(intent);
        });
        settings.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this,Settings.class);
            startActivity(intent1);
        });
    }
}