package com.example.tamagochi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;


import android.os.Bundle;



import android.widget.TextView;




public class Language extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            Intent back1 = new Intent(Language.this,Settings.class);
            startActivity(back1);
            finish();
        });
    }
    @Override
    public void onBackPressed() {}
}