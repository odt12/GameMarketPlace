package com.example.gamemarketplace;

import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String title;
    private int imageResourceId;

    public Product(int id, String title, int imageResourceId) {
        this.id = id;
        this.title = title;
        this.imageResourceId = imageResourceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}

