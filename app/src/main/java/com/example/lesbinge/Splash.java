package com.example.lesbinge;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.imageView);

        Handler handler = new Handler(Looper.myLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(),Login.class);
                //i.putExtra("imgURL",R.drawable.splash);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Splash.this,logo, "sharedNameLogo");
                startActivity(i,options.toBundle());
            }
        },2000);
    }
}