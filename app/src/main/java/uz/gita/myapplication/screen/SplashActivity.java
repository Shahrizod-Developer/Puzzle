package uz.gita.myapplication.screen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import uz.gita.myapplication.R;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        TextView text = findViewById(R.id.text);
        Animation slideAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);
        text.startAnimation(slideAnimation);
    }

    @Override
    protected void onStart() {
        super.onStart();

        CountDownTimer timer = new CountDownTimer(2000, 1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(SplashActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        };
        timer.start();
    }
}