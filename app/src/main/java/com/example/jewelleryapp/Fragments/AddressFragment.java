package com.example.jewelleryapp.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jewelleryapp.Adapters.AddressAdapter;
import com.example.jewelleryapp.Model.AddressModel;
import com.example.jewelleryapp.R;

import java.util.ArrayList;
import java.util.List;


public class AddressFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    List<AddressModel> addressModelList;
    CardView addAddressCard;

    public AddressFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_address, container, false);
        addAddressCard = v.findViewById(R.id.openaddAddress);

        addAddressCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddAddressFragment bookFragment = new AddAddressFragment();
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, bookFragment).addToBackStack(null).commit();

            }
        });


        loadAddressList();

        return v;
    }
    private void loadAddressList() {
        recyclerView = v.findViewById(R.id.addressListRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        addressModelList = new ArrayList<>();

        addressModelList.add(new AddressModel("709, Gaushala Road, City"));
        addressModelList.add(new AddressModel("709, Gaushala Road, City"));


        AddressAdapter addressAdapter = new AddressAdapter(addressModelList);
        recyclerView.setAdapter(addressAdapter);
    }

//    @Override
//    public void onItemClick(AddressModel address) {
//
//    }
}