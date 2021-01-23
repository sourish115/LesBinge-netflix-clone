package com.example.lesbinge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lesbinge.adapters.CastAdapter;
import com.example.lesbinge.models.Cast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MovieDetails extends AppCompatActivity {
    private ImageView movieImg, coverImage;
    private TextView movieTitleTv, movieDescTv;
    private FloatingActionButton fab;
    private RecyclerView castRv;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        initializeViews();

        setCastRvList();

    }

    private void initializeViews(){
        String movieTitle = getIntent().getExtras().getString("title");
        int imgURL = getIntent().getExtras().getInt("imgURL");
        int coverImageUrl = getIntent().getExtras().getInt("coverImg");
        movieImg = findViewById(R.id.movie_img);
        coverImage = findViewById(R.id.detail_movie_cover);
        movieTitleTv = findViewById(R.id.detail_movie_title);
        movieDescTv = findViewById(R.id.detail_movie_desc);
        castRv = findViewById(R.id.recyclerCast);
        fab = findViewById(R.id.play_fab);
        Glide.with(this).load(imgURL).into(movieImg);
        Glide.with(this).load(coverImageUrl).into(coverImage);
        movieTitleTv.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        coverImage.setAnimation(AnimationUtils.loadAnimation(this,R.anim.click_animation));
        fab.setAnimation(AnimationUtils.loadAnimation(this,R.anim.click_animation));

    }

    private void setCastRvList(){
        List<Cast> mData= new ArrayList<>();
        mData.add(new Cast("keanu Reeves", R.drawable.keanu_reeves));
        mData.add(new Cast("Emma Watson", R.drawable.emma_watson));
        mData.add(new Cast("Tom Hardy", R.drawable.tom_hardy));
        mData.add(new Cast("Mila Kunis", R.drawable.mila_kunis));

        castAdapter = new CastAdapter(this, mData);
        castRv.setAdapter(castAdapter);
        castRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

    }
}