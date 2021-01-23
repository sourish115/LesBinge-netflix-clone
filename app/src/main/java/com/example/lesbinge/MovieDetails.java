package com.example.lesbinge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MovieDetails extends AppCompatActivity {
    private ImageView movieImg, coverImage;
    private TextView movieTitleTv, movieDescTv;
    private FloatingActionButton fab;

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
        coverImage = findViewById(R.id.detail_movie_cover);
        movieTitleTv = findViewById(R.id.detail_movie_title);
        movieDescTv = findViewById(R.id.detail_movie_desc);
        fab = findViewById(R.id.play_fab);
        Glide.with(this).load(imgURL).into(movieImg);
        Glide.with(this).load(coverImageUrl).into(coverImage);
        movieTitleTv.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        coverImage.setAnimation(AnimationUtils.loadAnimation(this,R.anim.click_animation));
        fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.click_animation));

    }
}