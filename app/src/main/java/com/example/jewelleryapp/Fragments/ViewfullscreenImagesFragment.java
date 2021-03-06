package com.example.jewelleryapp.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.example.jewelleryapp.R;
import com.example.jewelleryapp.ZoomView;

public class ViewfullscreenImagesFragment extends Fragment implements ZoomView.ZoomViewListener {
    public ViewfullscreenImagesFragment() {
        // Required empty public constructor
    }
    View v;

   ZoomView zoomView;
   String img;
   ImageView imageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_viewfullscreen_images, container, false);

       imageView = v.findViewById(R.id.imageView);

       zoomView.addView(imageView);

        if(getArguments()!=null){
            img = getArguments().getString("img");
            Glide.with(v.getContext()).load(img).into(imageView);
        }
        Log.e("URL2",img);
        Toast.makeText(getContext(), img, Toast.LENGTH_SHORT).show();
        return v;
    }

    @Override
    public void onZoomStarted(float zoom, float zoomx, float zoomy) {

    }

    @Override
    public void onZooming(float zoom, float zoomx, float zoomy) {

    }

    @Override
    public void onZoomEnded(float zoom, float zoomx, float zoomy) {

    }
}