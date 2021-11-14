package com.a1techandroid.test_preperation_app;

import android.graphics.drawable.Drawable;

import org.w3c.dom.Text;

public class MainGridModel {
    Drawable image;
    String name;

    public MainGridModel(Drawable image, String name) {
        this.image = image;
        this.name = name;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
