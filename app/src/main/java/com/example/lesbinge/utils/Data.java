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
        moviesList.add(new Movies("The Martian", R.drawable.themartian, R.drawable.slide2));
        moviesList.add(new Movies("Moana", R.drawable.moana, R.drawable.slide1));

        return moviesList;
    }

    public static List<SlideModel> getSlideList(){
        List<SlideModel> mList = new ArrayList<>();
        mList.add(new SlideModel(R.drawable.slide1, "Wolverine"));
        mList.add(new SlideModel(R.drawable.slide2, "Fantastic Beasts"));
        mList.add(new SlideModel(R.drawable.spidercover, "Amazing Spider-man"));
        mList.add(new SlideModel(R.drawable.slide2, "Fantabulous Beasts"));
        mList.add(new SlideModel(R.drawable.slide1, "Wolverine: Fangs"));

        return mList;
    }

    public static List<Movies> getPopMovies(){
        List<Movies> moviesList = new ArrayList<>();
        moviesList.add(new Movies("The Martian", R.drawable.themartian, R.drawable.slide2));
        moviesList.add(new Movies("Black P", R.drawable.blackp, R.drawable.spidercover));
        moviesList.add(new Movies("Moana", R.drawable.moana, R.drawable.slide1));

        return moviesList;
    }
}
