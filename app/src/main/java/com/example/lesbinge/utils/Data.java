package com.example.lesbinge.utils;

import com.example.lesbinge.R;
import com.example.lesbinge.models.Movies;
import com.example.lesbinge.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Movies> getMovies(){
        List<Movies> moviesList = new ArrayList<>();
        moviesList.add(new Movies("Moana", R.drawable.moana, R.drawable.spidercover));
        moviesList.add(new Movies("Black P", R.drawable.blackp, R.drawable.spidercover));
        moviesList.add(new Movies("The Martian", R.drawable.themartian));
        moviesList.add(new Movies("Moana", R.drawable.moana));

        return moviesList;
    }

    public static List<SlideModel> getSlideList(){
        List<SlideModel> mList = new ArrayList<>();
        mList.add(new SlideModel(R.drawable.slide1, "SHOW1"));
        mList.add(new SlideModel(R.drawable.slide2, "SHOW1"));
        mList.add(new SlideModel(R.drawable.slide1, "SHOW1"));
        mList.add(new SlideModel(R.drawable.slide2, "SHOW1"));
        mList.add(new SlideModel(R.drawable.slide1, "SHOW1"));

        return mList;
    }
}
