package com.codevated.mealafriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {
    ImageView logoImg;
    Animation fromTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        logoImg = (ImageView) findViewById(R.id.logo_img);

        fromTop = AnimationUtils.loadAnimation(this,R.anim.from_top);

        logoImg.setAnimation(fromTop);

        final Intent intent = new Intent(this, SearchActivity.class);

        Thread timer = new Thread(){
            public void run(){

                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }

}
