package com.example.jewelleryapp;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jewelleryapp.CustmizedProjects.Models.CustomD_Model;
import com.example.jewelleryapp.CustmizedProjects.Models.CustomDesItemsAdapter;
import com.example.jewelleryapp.CustmizedProjects.Models.CustomDesignAdapter;
import com.example.jewelleryapp.CustmizedProjects.Models.P_SpecificationModel;
import com.example.jewelleryapp.Model.SelectedData;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class BottomCustomDesignFragment extends BottomSheetDialogFragment implements CustomDesItemsAdapter.ItemClickListener {

    public static BottomCustomDesignFragment newInstance() {
        return new BottomCustomDesignFragment();
    }

    ArrayList<String> listItem = new ArrayList<>();
    ArrayAdapter<String> adapter;
    List<CustomD_Model> customD_modelList;
    List<P_SpecificationModel> p_specificationModelsList;
    RecyclerView recyclerView;
    View v;
    CardView increaseBtn,decreaseBtn;
    TextView quantityTextView;
    CardView applyCardView;
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

        adapter = new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_list_item_1,listItem);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        customD_modelList = new ArrayList<>();

        customD_modelList.add(new CustomD_Model("Colors",1));
        customD_modelList.add(new CustomD_Model("Types",2));
        customD_modelList.add(new CustomD_Model("Verities",3));





        CustomDesignAdapter  customDesignAdapter = new CustomDesignAdapter(customD_modelList,p_specificationModelsList,0,this);
        recyclerView.setAdapter(customDesignAdapter);


    }

    private void initIds() {
        increaseBtn      = v.findViewById(R.id.increaseQuantity);
        decreaseBtn      = v.findViewById(R.id.decreaseQuantity);
        quantityTextView = v.findViewById(R.id.quantityTextView);
        recyclerView     = v.findViewById(R.id.changePrecycler);
        applyCardView    = v.findViewById(R.id.applyCardView);
        quantityTextView.setText("1");
    }

    private void productQuantity() {
        productQuantity = 1;
        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(quantityTextView.getText().toString()) <= 12) {
                    productQuantity++;
                    quantityTextView.setText(String.valueOf(productQuantity));
                }
            }
        });
        decreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(quantityTextView.getText().toString()) >= 1) {
                    productQuantity--;
                    quantityTextView.setText(String.valueOf(productQuantity));
                }
            }
        });

        applyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0;i<=listItem.size();i++) {
                    try {
                        Log.e("Data Id", String.valueOf(listItem.get(i).toString()));
                    }catch (IndexOutOfBoundsException e){
                        e.printStackTrace();
                    }
                }
                Toast.makeText(v.getContext(), String.valueOf(listItem.size()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void OnItemClick(int idsList, int selectedItemPos) {
        listItem.add(String.valueOf(idsList+","+selectedItemPos));
        adapter.notifyDataSetChanged();

        Toast.makeText(v.getContext(), String.valueOf(listItem.size()), Toast.LENGTH_SHORT).show();



    }
}