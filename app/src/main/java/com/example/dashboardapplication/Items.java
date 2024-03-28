package com.example.dashboardapplication;

import android.graphics.drawable.Drawable;

public class Items {

    String name;
    int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Items(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
