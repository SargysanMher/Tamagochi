package com.example.tamagochi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class Settings extends AppCompatActivity {
Button rules,language,difficulty;
    int diff=0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        rules = findViewById(R.id.rules);
        language = findViewById(R.id.language);
        difficulty = findViewById(R.id.difficulty);

        Intent i= getIntent();
        diff = i.getIntExtra("DIFF",0);

        TextView back = findViewById(R.id.back);
        rules.setOnClickListener(view -> {
              Intent intent = new Intent(Settings.this,Rules.class);
              startActivity(intent);
            finish();
        });
        language.setOnClickListener(view -> {
            Intent intent1 = new Intent(Settings.this,Language.class);
            startActivity(intent1);
            finish();

        });
        difficulty.setOnClickListener(view -> {
            Intent intent2 = new Intent(Settings.this,Difficulty.class);
            startActivity(intent2);
            finish();
        });
        back.setOnClickListener(v -> {
            Intent back1 = new Intent(Settings.this,MainActivity.class);
            back1.putExtra("DIFF", diff);
            startActivity(back1);

            finish();
        });

    }

    @Override
    public void onBackPressed() {
    }
}