package com.example.lesbinge.adapters;

import android.widget.ImageView;

import com.example.lesbinge.models.Movies;

public interface MovieItemClickListener {

    void onMovieClick(Movies movie, ImageView movieImageView); // we will need the imageview to make the shared animation between the two activity

}