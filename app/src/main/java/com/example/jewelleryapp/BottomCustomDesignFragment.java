package com.example.jewelleryapp;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.jewelleryapp.CustmizedProjects.Models.CustomD_Model;
import com.example.jewelleryapp.CustmizedProjects.Models.CustomDesignAdapter;
import com.example.jewelleryapp.CustmizedProjects.Models.P_SpecificationModel;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomCustomDesignFragment extends BottomSheetDialogFragment {

    public static BottomCustomDesignFragment newInstance() {
        return new BottomCustomDesignFragment();
    }


    List<CustomD_Model> customD_modelList;
    List<P_SpecificationModel> p_specificationModelsList;
    RecyclerView recyclerView;
    View v;
    CardView increaseBtn,decreaseBtn;
    TextView quantityTextView;
    int productQuantity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_bottom_custom_design, container, false);
        initIds();
        loadItems();
        productQuantity();
        return v;
    }

    private void loadItems() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        customD_modelList = new ArrayList<>();
        customD_modelList.add(new CustomD_Model("Metal Color",1));

        p_specificationModelsList = new ArrayList<>();
        p_specificationModelsList.add(new P_SpecificationModel("Blue",1));
        p_specificationModelsList.add(new P_SpecificationModel("Red",2));
        p_specificationModelsList.add(new P_SpecificationModel("Yellow",3));



        CustomDesignAdapter  customDesignAdapter = new CustomDesignAdapter(customD_modelList,p_specificationModelsList,0);
        recyclerView.setAdapter(customDesignAdapter);


    }

    private void initIds() {
        increaseBtn      = v.findViewById(R.id.increaseQuantity);
        decreaseBtn      = v.findViewById(R.id.decreaseQuantity);
        quantityTextView = v.findViewById(R.id.quantityTextView);
        recyclerView     = v.findViewById(R.id.changePrecycler);
        quantityTextView.setText("1");
    }

    private void productQuantity(){
        productQuantity = 1;
        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(quantityTextView.getText().toString()) <= 12){
                    productQuantity++;
                    quantityTextView.setText(String.valueOf(productQuantity));
                }
            }
        });
        decreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(quantityTextView.getText().toString()) >= 1){
                    productQuantity--;
                    quantityTextView.setText(String.valueOf(productQuantity));
                }
            }
        });

    }
}