package com.example.tamagochi;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private boolean is_started=true;
    TextView satiety,fatigue,gladness,counter,finish,result;
    String p,food,hognacutyun,uraxutyun;
    Button uraxanal,utel,tarmanal;
    int a =100;
    int b =100;
    int c =100;
    int h = 1;
    int j = 0;
    int counter1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        satiety = findViewById(R.id.satiety);
        fatigue = findViewById(R.id.fatigue);
        gladness = findViewById(R.id.gladness);
        counter = findViewById(R.id.counter);
        finish = findViewById(R.id.finish);
        utel = findViewById(R.id.utel);
        tarmanal = findViewById(R.id.tarmanal);
        uraxanal = findViewById(R.id.uraxanal);
        result = findViewById(R.id.result);








        new Thread() {
            @Override
            public void run() {
                tarmanal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(b<100){
                            if(b+4==100){
                                b+=4;
                            }
                            else if(b+3==100){
                                b+=3;
                            }
                            else if(b+2==100){
                                b+=2;
                            }
                            else if(b+1==100){
                                b+=1;
                            }
                            else{
                                b+=5;
                            }

                            hognacutyun = String.valueOf(b);
                            runOnUiThread(()->{
                                fatigue.setText(hognacutyun);
                            });
                        }



                    }
                });
                uraxanal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(c<100){
                            if(c+4==100){
                                c+=4;
                            }
                            else if(c+3==100){
                                c+=3;
                            }
                            else if(c+2==100){
                                c+=2;
                            }
                            else if(c+1==100){
                                c+=1;
                            }
                            else{
                                c+=5;
                            }

                            uraxutyun = String.valueOf(c);
                            runOnUiThread(()->{
                                gladness.setText(uraxutyun);
                            });
                        }



                    }
                });

                utel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(a<100){
                            if(a+4==100){
                                a+=4;
                            }
                            else if(a+3==100){
                                a+=3;
                            }
                            else if(a+2==100){
                                a+=2;
                            }
                            else if(a+1==100){
                                a+=1;
                            }
                            else{
                                a+=5;
                            }
                            food = String.valueOf(a);
                            runOnUiThread(()->{
                                satiety.setText(food);
                            });
                        }

                    }

                });
                while (is_started) {
                    food = String.valueOf(a);
                    uraxutyun = String.valueOf(c);
                    hognacutyun = String.valueOf(b);

                    runOnUiThread(() -> {

                        satiety.setText(food);
                        gladness.setText(uraxutyun);
                        fatigue.setText(hognacutyun);
                    });
                    if(a<0||b<0||c<0){
                        runOnUiThread(() ->{
                            finish.setText("The Game is finished, your marduk died");
                            result.setText("your score was "+ counter1);

                        });

                        is_started=false;
                        break;
                    }


                    counter1++;
                    p = String.valueOf(counter1);
                    runOnUiThread(() -> {
                        counter.setText(p);
                    });
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    counter1++;
                    p = String.valueOf(counter1);
                    runOnUiThread(() -> {
                        counter.setText(p);
                    });


                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a -= h;
                    b -= h;
                    c -= h;






                    if(counter1==j+10){
                        j=counter1;
                        h++;
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
}