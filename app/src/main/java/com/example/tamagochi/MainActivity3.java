package com.example.tamagochi;



import java.io.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.PopupMenu;
import android.widget.TextView;




public class MainActivity3 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private boolean is_started=true;
    private final static String FILE_NAME = "Best_hard.txt";
    TextView satiety,fatigue,gladness,counter,finish,money,stop;
    String p,food,hognacutyun,uraxutyun,money2;
    Button uraxanal,utel,tarmanal,ashxatel;
    int a =100;
    int b =100;
    int c =100;
    int diff = 1;
    int h = 1;
    int element = 0;
    int j = 0;
    int money1 = 100;
    int counter1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ashxatel = findViewById(R.id.ashxatel);
        money=findViewById(R.id.money);
        satiety = findViewById(R.id.satiety);
        fatigue = findViewById(R.id.fatigue);
        gladness = findViewById(R.id.gladness);
        stop = findViewById(R.id.stop);
        Intent i= getIntent();
        counter = findViewById(R.id.counter);
        finish = findViewById(R.id.finish);
        utel = findViewById(R.id.utel);
        tarmanal = findViewById(R.id.tarmanal);
        uraxanal = findViewById(R.id.uraxanal);






        new Thread() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {

                while (true) {
                    while (is_started) {
                        if (a <= 0 || b <= 0 || c <= 0) {


                            FileOutputStream fos = null;
                            FileInputStream fin = null;

                            try {
                                fin = openFileInput(FILE_NAME);
                                element = fin.read();

                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                try {
                                    if (fin != null) {
                                        fin.close();
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }


                            try {

                                if (counter1 > element) {
                                    fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
                                    fos.write(counter1);
                                    fin = openFileInput(FILE_NAME);
                                    element = fin.read();
                                }


                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {

                                try {
                                    if (fos != null) {
                                        fos.close();
                                    }
                                    if (fin != null) {
                                        fin.close();
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }




                            runOnUiThread(() -> finish.setText("The Game is finished, your marduk died.\n Your score was " + counter1 + "\n Your best result is " + element));
                            is_started = false;
                            break;
                        }
                        ashxatel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                money1 += 5;
                                b -= 5;
                                money2 = String.valueOf(money1);
                                runOnUiThread(() -> money.setText(money2));
                                hognacutyun = String.valueOf(b);
                                runOnUiThread(() -> fatigue.setText(hognacutyun));
                            }
                        });
                        tarmanal.setOnClickListener(view -> {
                            if (b < 100) {
                                if (b + 4 == 100) {
                                    b += 4;
                                } else if (b + 3 == 100) {
                                    b += 3;
                                } else if (b + 2 == 100) {
                                    b += 2;
                                } else if (b + 1 == 100) {
                                    b += 1;
                                } else {
                                    b += 5;
                                }

                                hognacutyun = String.valueOf(b);
                                runOnUiThread(() -> fatigue.setText(hognacutyun));
                            }


                        });
                        uraxanal.setOnClickListener(view -> {
                            if (c < 100 & money1 > 0) {
                                if (c + 4 == 100) {
                                    c += 4;
                                    money1 -= 8;
                                } else if (c + 3 == 100) {
                                    c += 3;
                                    money1 -= 6;
                                } else if (c + 2 == 100) {
                                    c += 2;
                                    money1 -= 4;
                                } else if (c + 1 == 100) {
                                    c += 1;
                                    money1 -= 2;
                                } else {
                                    c += 5;
                                    money1 -= 10;
                                }

                                uraxutyun = String.valueOf(c);
                                runOnUiThread(() -> gladness.setText(uraxutyun));
                                money2 = String.valueOf(money1);
                                runOnUiThread(() -> money.setText(money2));
                            }


                        });

                        utel.setOnClickListener(view -> {
                            if (a < 100 & money1 > 0) {
                                if (a + 4 == 100) {
                                    a += 4;
                                    money1 -= 8;
                                } else if (a + 3 == 100) {
                                    a += 3;
                                    money1 -= 6;
                                } else if (a + 2 == 100) {
                                    a += 2;
                                    money1 -= 4;
                                } else if (a + 1 == 100) {
                                    a += 1;
                                    money1 -= 2;
                                } else {
                                    a += 5;
                                    money1 -= 10;
                                }
                                food = String.valueOf(a);
                                runOnUiThread(() -> satiety.setText(food));
                                money2 = String.valueOf(money1);
                                runOnUiThread(() -> money.setText(money2));
                            }

                        });
                        if(a>0&b>0&c>0){
                            food = String.valueOf(a);
                            uraxutyun = String.valueOf(c);
                            hognacutyun = String.valueOf(b);
                            money2 = String.valueOf(money1);
                            runOnUiThread(() -> {
                                satiety.setText(food);
                                gladness.setText(uraxutyun);
                                fatigue.setText(hognacutyun);
                                money.setText(money2);
                            });




                            counter1++;
                            p = String.valueOf(counter1);
                            runOnUiThread(() -> counter.setText(p));
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            counter1++;
                            p = String.valueOf(counter1);
                            if(is_started){
                                runOnUiThread(() -> counter.setText(p));
                            }else{
                                continue;
                            }
                        }




                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        a -= h;
                        b -= h;
                        c -= h;


                        if (counter1 == j + 10) {
                            j = counter1;
                            h++;
                        }


                    }
                }
            }

        }.start();


    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        is_started=false;
    }
    @SuppressLint("ResourceType")
    public void showPopup(View v){
        is_started = false;
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener( this);
        stop.setVisibility(View.VISIBLE);
        popupMenu.inflate(R.menu.popup);
        popupMenu.show();
    }



    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()){
            case R.id.back:
                Intent i = new Intent(MainActivity3.this,MainActivity.class);
                i.putExtra("DIFF",diff);
                startActivity(i);
                finish();
                stop.setVisibility(View.GONE);
                is_started = true;
                return true;
            case R.id.resume:
                is_started = true;
                stop.setVisibility(View.GONE);
                return true;
            case R.id.restart:
                a=100;b=100;c=100;counter1=0;money1=100;h=1;
                is_started = true;
                finish.setText("");
                stop.setVisibility(View.GONE);
                return true;
            default:
                is_started = true;
                stop.setVisibility(View.GONE);
                return false;
        }

    }

}