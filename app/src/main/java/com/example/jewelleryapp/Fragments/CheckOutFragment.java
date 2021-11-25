package com.example.jewelleryapp.Fragments;

import android.location.Address;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
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


public class CheckOutFragment extends Fragment implements AddressAdapter.ItemClickListener{

    public CheckOutFragment() {
        // Required empty public constructor
    }
    View v;
    RecyclerView recyclerView;
    List<AddressModel> addressModelList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_check_out, container, false);

        recyclerView = v.findViewById(R.id.addressListRecycler);

        loadAddressList();


        return v;
    }

    private void loadAddressList() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        addressModelList = new ArrayList<>();

        addressModelList.add(new AddressModel("709, Gaushala Road, City"));

        AddressAdapter addressAdapter = new AddressAdapter(addressModelList);
        recyclerView.setAdapter(addressAdapter);
    }

    @Override
    public void onItemClick(AddressModel address) {


    }
}