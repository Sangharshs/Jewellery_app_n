package com.example.jewelleryapp.Model;

import com.google.gson.annotations.SerializedName;

public class ProductImages {

    @SerializedName("imgpath")
    String imgpath;

    public ProductImages(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }
}
