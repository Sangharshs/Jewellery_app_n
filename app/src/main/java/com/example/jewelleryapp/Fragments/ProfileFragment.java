package com.example.jewelleryapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jewelleryapp.R;
import com.example.jewelleryapp.TinyDB;
import com.google.android.material.textfield.TextInputEditText;

public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    TextInputEditText nameEditText,phoneNumEditText,emailEditText,addressEditText,pincodeEditText,
    landMarkEdittext,stateEditText,cityEditText;
    View v;
    TinyDB tinyDB;
    String userName,userId,userEmail,userNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_profile, container, false);


        findViewByIds();
        setStoredData();
        return v;
    }

    private void setStoredData() {
        tinyDB = new TinyDB(getContext());
        userName = tinyDB.getString("username");
        userEmail = tinyDB.getString("email");
        userNumber = tinyDB.getString("mobile");

        nameEditText.setText(userName);
        emailEditText.setText(userEmail);
        phoneNumEditText.setText(userNumber);
    }

    private void findViewByIds() {
        nameEditText = v.findViewById(R.id.fullname_ed);
        phoneNumEditText = v.findViewById(R.id.phone_ed);
        emailEditText = v.findViewById(R.id.email_edittetxt);
        addressEditText = v.findViewById(R.id.address1edittext);
        pincodeEditText = v.findViewById(R.id.pincode_edittext);
        landMarkEdittext = v.findViewById(R.id.landmark_edittext);
        cityEditText = v.findViewById(R.id.city_edittext);
        stateEditText = v.findViewById(R.id.state_edittext);
    }


}