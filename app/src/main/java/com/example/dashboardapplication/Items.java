package com.example.dashboardapplication;

public class Items {

    String name, image;

    public Items(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImage() {
        return image;
    }
}
