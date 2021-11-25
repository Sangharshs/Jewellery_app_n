package com.example.jewelleryapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jewelleryapp.Model.CartProduct;
import com.example.jewelleryapp.R;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    List<CartProduct> cartProductList;

    public CartAdapter(List<CartProduct> cartProductList) {
        this.cartProductList = cartProductList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_design,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return cartProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cartProductImage;
        TextView productName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
