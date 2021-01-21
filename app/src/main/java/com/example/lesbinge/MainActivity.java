package com.example.lesbinge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.lesbinge.adapters.MovieAdapter;
import com.example.lesbinge.adapters.MovieItemClickListener;
import com.example.lesbinge.adapters.SlidePageAdapter;
import com.example.lesbinge.models.Movies;
import com.example.lesbinge.models.SlideModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private List<SlideModel> slideList;
    private ViewPager pagerSlider;
    private TabLayout indicator;
    private RecyclerView Movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerSlider = findViewById(R.id.page_slider);
        indicator = findViewById(R.id.indicator);
        Movies = findViewById(R.id.Rv_movies);

        slideList = new ArrayList<>();
        slideList.add(new SlideModel(R.drawable.slide1, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide2, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide1, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide2, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide1, "SHOW1"));

        SlidePageAdapter slideAdapter = new SlidePageAdapter(this,slideList);
        pagerSlider.setAdapter(slideAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(),4000,6000);

        indicator.setupWithViewPager(pagerSlider);

        List<Movies> moviesList = new ArrayList<>();
        MovieItemClickListener listener = null;
        moviesList.add(new Movies("Moana", R.drawable.moana));
        moviesList.add(new Movies("Black P", R.drawable.blackp));
        moviesList.add(new Movies("The Martian", R.drawable.themartian));
        moviesList.add(new Movies("Moana", R.drawable.moana));

        MovieAdapter movieAdapter = new MovieAdapter(this, moviesList, listener);
        Movies.setAdapter(movieAdapter);
        Movies.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
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