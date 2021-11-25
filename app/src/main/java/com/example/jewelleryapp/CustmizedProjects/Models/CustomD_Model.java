package com.example.jewelleryapp.CustmizedProjects.Models;

public class CustomD_Model {
    String designName;
    int id;


    public CustomD_Model(String designName, int id) {
        this.designName = designName;
        this.id = id;
    }

    public String getDesignName() {
        return designName;
    }

    public void setDesignName(String designName) {
        this.designName = designName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
