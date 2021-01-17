package com.example.lesbinge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.lesbinge.adapters.SlidePageAdapter;
import com.example.lesbinge.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<SlideModel> slideList;
    private ViewPager pagerSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerSlider = findViewById(R.id.page_slider);

        slideList = new ArrayList<>();
        slideList.add(new SlideModel(R.drawable.slide1, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide2, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide1, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide2, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide1, "SHOW1"));

        SlidePageAdapter slideAdapter = new SlidePageAdapter(this,slideList);
        pagerSlider.setAdapter(slideAdapter);
    }
}