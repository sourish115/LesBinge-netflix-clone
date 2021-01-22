package com.example.lesbinge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MovieDetails extends AppCompatActivity {
    private ImageView movieImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        movieImg = findViewById(R.id.movie_img);

        String movieTitle = getIntent().getExtras().getString("title");
        int imgURL = getIntent().getExtras().getInt("imgURL");

        movieImg.setImageResource(imgURL);
    }
}