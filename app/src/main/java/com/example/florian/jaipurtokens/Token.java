package com.example.florian.jaipurtokens;

import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by Florian on 18/08/2017.
 */

public class Token implements Serializable {

    private int resid;
    private int value;
    private ImageView imageView;

    public Token(int resid, int value) {
        this.resid = resid;
        this.value = value;
    }
    public int getResid() {
            return resid;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageView getImageView() {

        return imageView;
    }

    public int getValue() {
        return value;
    }

}
