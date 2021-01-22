package com.example.lesbinge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetails extends AppCompatActivity {
    private ImageView movieImg, coverImage;
    private TextView movieTitleTv, movieDescTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        initializeViews();

    }

    private void initializeViews(){
        String movieTitle = getIntent().getExtras().getString("title");
        int imgURL = getIntent().getExtras().getInt("imgURL");
        int coverImageUrl = getIntent().getExtras().getInt("coverImg");
        movieImg = findViewById(R.id.movie_img);
        coverImage = findViewById(R.id.imageView);
        movieTitleTv = findViewById(R.id.detail_movie_title);
        movieDescTv = findViewById(R.id.detail_movie_desc);
        Glide.with(this).load(imgURL).into(movieImg);
        Glide.with(this).load(coverImageUrl).into(coverImage);
        movieTitleTv.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);

    }
}