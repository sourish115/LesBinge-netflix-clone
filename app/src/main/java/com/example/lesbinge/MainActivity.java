package com.example.lesbinge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.lesbinge.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<SlideModel> slideList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slideList = new ArrayList<>();
        slideList.add(new SlideModel(R.drawable.slide1, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide2, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide1, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide2, "SHOW1"));
        slideList.add(new SlideModel(R.drawable.slide1, "SHOW1"));
    }
}