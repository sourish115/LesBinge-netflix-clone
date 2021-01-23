package com.example.lesbinge.models;

public class Cast {

    String castName;
    int imageResource;

    public Cast(String castName, int imageResource) {
        this.castName = castName;
        this.imageResource = imageResource;
    }

    public void setCastName(String castName) {
        this.castName = castName;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getCastName() {
        return castName;
    }

    public int getImageResource() {
        return imageResource;
    }
}
