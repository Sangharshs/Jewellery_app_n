package com.example.jewelleryapp.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jewelleryapp.Adapters.CartAdapter;
import com.example.jewelleryapp.Adapters.CategoryAdapter;
import com.example.jewelleryapp.Model.CartProduct;
import com.example.jewelleryapp.Model.ProductCategory;
import com.example.jewelleryapp.R;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    CartAdapter categoryAdapter;
    List<CartProduct> categoriesList;
    CardView checkOutCard;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_cart, container, false);
        checkOutCard = v.findViewById(R.id.checkOutCardView);


        recyclerView = v.findViewById(R.id.cartProductRecyclerView);
        fetchProductsCartProduct();


        checkOutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddressFragment bookFragment = new AddressFragment();
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, bookFragment).addToBackStack(null).commit();

            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    private void fetchProductsCartProduct() {
        LinearLayoutManager gridLayoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(gridLayoutManager);

        categoriesList = new ArrayList<>();

        categoriesList.add(new CartProduct("Test","Rs 2000","",""));

        categoryAdapter = new CartAdapter(categoriesList);
        recyclerView.setAdapter(categoryAdapter);

    }
}