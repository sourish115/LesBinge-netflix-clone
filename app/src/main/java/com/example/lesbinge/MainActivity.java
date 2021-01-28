package com.example.lesbinge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lesbinge.adapters.MovieAdapter;
import com.example.lesbinge.adapters.MovieItemClickListener;
import com.example.lesbinge.adapters.SlidePageAdapter;
import com.example.lesbinge.models.Movies;
import com.example.lesbinge.models.SlideModel;
import com.example.lesbinge.utils.Data;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements MovieItemClickListener{

    private List<SlideModel> slideList;
    private ViewPager pagerSlider;
    private TabLayout indicator;
    private RecyclerView Movies, popularMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerSlider = findViewById(R.id.page_slider);
        indicator = findViewById(R.id.indicator);
        Movies = findViewById(R.id.Rv_movies);
        popularMovies = findViewById(R.id.Rv_pop_movies);

        initSlide();
        initMoviesRv();
        initPopularMovies();
    }

    private void initSlide() {
        slideList = Data.getSlideList();
        SlidePageAdapter slideAdapter = new SlidePageAdapter(this,slideList);
        pagerSlider.setAdapter(slideAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(),4000,6000);
        indicator.setupWithViewPager(pagerSlider,true);
    }

    private void initMoviesRv() {
        MovieAdapter movieAdapter = new MovieAdapter(this, Data.getMovies(), this);
        Movies.setAdapter(movieAdapter);
        Movies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
    }

    private void initPopularMovies(){
        MovieAdapter movieAdapter = new MovieAdapter(this,Data.getMovies(),this);
        popularMovies.setAdapter(movieAdapter);
        popularMovies.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public void onMovieClick(com.example.lesbinge.models.Movies movie, ImageView movieImageView) {

        Intent intent = new Intent(getApplicationContext(),MovieDetails.class);
        intent.putExtra("title", movie.getTitle());
        intent.putExtra("imgURL", movie.getThumbnail());
        intent.putExtra("coverImg",movie.getCoverPhoto());

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,
                movieImageView,"sharedName");

        startActivity(intent, options.toBundle());
    }


    class SliderTimer extends TimerTask {
        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (pagerSlider.getCurrentItem()<slideList.size()-1) {
                        pagerSlider.setCurrentItem(pagerSlider.getCurrentItem()+1);
                    }
                    else
                        pagerSlider.setCurrentItem(0);
                }
            });
        }
    }
}