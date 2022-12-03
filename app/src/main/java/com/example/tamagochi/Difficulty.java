package com.example.tamagochi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Difficulty extends AppCompatActivity {
    public int diff=0;
    TextView back;
    Button hard, easy;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        hard = findViewById(R.id.hard);
        back = findViewById(R.id.back);
        easy = findViewById(R.id.easy);
        hard.setOnClickListener(v -> diff = 1);
        easy.setOnClickListener(v -> diff = 0);
        back.setOnClickListener(v -> {
            Intent back = new Intent(Difficulty.this,Settings.class);
            back.putExtra("DIFF",diff);
            startActivity(back);

            finish();
        });
    }
    @Override
    public void onBackPressed() {}
}