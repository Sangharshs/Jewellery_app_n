package com.example.jewelleryapp.Model;

import com.google.gson.annotations.SerializedName;

public class P_Details_A {
    @SerializedName("id")
    int id;

    @SerializedName("type")
    String type;

    @SerializedName("quantity")
    int quantity;

    public P_Details_A(int id, String type, int quantity) {
        this.id = id;
        this.type = type;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
