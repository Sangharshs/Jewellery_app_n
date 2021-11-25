package com.example.jewelleryapp.Model;

import com.google.gson.annotations.SerializedName;

public class HorizontalProductImage {


    @SerializedName("imgpath")
    String imgpath;

    public HorizontalProductImage(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

}
