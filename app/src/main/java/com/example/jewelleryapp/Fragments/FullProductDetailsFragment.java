package com.example.jewelleryapp.Fragments;

import static com.example.jewelleryapp.Retrofit.ApiUtils.BASE_URL;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.jewelleryapp.Adapters.HorizontalProductListAdapter;
import com.example.jewelleryapp.Adapters.ProductImagesAdapter;
import com.example.jewelleryapp.Adapters.SliderAdapter;
import com.example.jewelleryapp.BottomCustomDesignFragment;
import com.example.jewelleryapp.Model.CategoryData;
import com.example.jewelleryapp.Model.HorizontalProductImage;
import com.example.jewelleryapp.Model.ProductImages;
import com.example.jewelleryapp.Model.SliderItem;
import com.example.jewelleryapp.R;
import com.example.jewelleryapp.Retrofit.ApiInterface;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FullProductDetailsFragment extends Fragment implements HorizontalProductListAdapter.ItemClickListener{

    public FullProductDetailsFragment() {
        // Required empty public constructor
    }
    View v;
    RecyclerView recyclerView;
    ArrayList<HorizontalProductImage> horizontalProductImageList;
    CardView showFragFromBottom;
    ImageCarousel carousel;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;
    String productName,productImg,productPrice;
    double discountedPrice;
    int productId;
    TextView productNameText, productPriceText,discountedPriceTv;
    private Handler sliderHandler = new Handler();
    private ViewPager2 viewPager2;
    private Activity mActivity;
    int position;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_full_product_details, container, false);

        getValues();
        findViewByIds();
        loadHorizontalProducts(this);
        setOnClickListeners();
        setViews();
        loadSlider();
        return v;
    }

    private void setViews() {
        productNameText.setText(productName);
        productPriceText.setText("MRP: "+productPrice);
        discountedPriceTv.setText(String.valueOf(discountedPrice));
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setOnClickListeners() {
        mScaleGestureDetector = new ScaleGestureDetector(v.getContext(), new ScaleListener());
        mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
        showFragFromBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialogFragment bottomSheetFragment = new BottomCustomDesignFragment();
                bottomSheetFragment.show(getActivity().getSupportFragmentManager(), bottomSheetFragment.getTag());

            }
        });
    }

    private void findViewByIds() {
        productPriceText = v.findViewById(R.id.productPriceMain);
        productNameText  = v.findViewById(R.id.productNameMain);
        recyclerView = v.findViewById(R.id.horizontalProductListRecycler);
        showFragFromBottom = v.findViewById(R.id.showBottomFragment);
        carousel = v.findViewById(R.id.carousel);
        discountedPriceTv = v.findViewById(R.id.ProductMRPPrices);
        viewPager2 = v.findViewById(R.id.viewpager);
        viewPager2.setVisibility(View.GONE);
    }

    private void getValues() {
        if(getArguments()!=null){
            productId = getArguments().getInt("product_id");
            productImg = getArguments().getString("product_img");
            productName = getArguments().getString("product_name");
            productPrice = getArguments().getString("product_price");
            discountedPrice = getArguments().getDouble("product_discounted_price");
        }
    }



    private void loadHorizontalProducts(HorizontalProductListAdapter.ItemClickListener clickListener) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) // Specify your api here
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);

        horizontalProductImageList = new ArrayList<>();

        Call<ArrayList<HorizontalProductImage>> call = api.getProductImages(productId);

        call.enqueue(new Callback<ArrayList<HorizontalProductImage>>() {
            @Override
            public void onResponse(Call<ArrayList<HorizontalProductImage>> call, Response<ArrayList<HorizontalProductImage>> response) {
                if(response.isSuccessful()){
                    Log.e("||||===||||", response.raw().toString() + response.body().toString());

                    horizontalProductImageList = response.body();

                    HorizontalProductListAdapter adapter = new HorizontalProductListAdapter(horizontalProductImageList,clickListener);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<HorizontalProductImage>> call, Throwable t) {

            }
        });

        HorizontalProductListAdapter adapter = new HorizontalProductListAdapter(horizontalProductImageList,this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void OnItemClick(int postion) {
        position = postion;
        viewPager2.setCurrentItem(postion);
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f,
                    Math.min(mScaleFactor, 10.0f));
            carousel.setScaleX(mScaleFactor);
            carousel.setScaleY(mScaleFactor);
            return true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        mScaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private void loadSlider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL) // Specify your api here
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface api = retrofit.create(ApiInterface.class);

        Call<ArrayList<HorizontalProductImage>> call = api.getProductImages(productId);

        call.enqueue(new Callback<ArrayList<HorizontalProductImage>>() {
            @Override
            public void onResponse(Call<ArrayList<HorizontalProductImage>> call, Response<ArrayList<HorizontalProductImage>> response) {
                if (response.isSuccessful()) {
                    viewPager2.setVisibility(View.VISIBLE);
                    horizontalProductImageList = response.body();
                    Log.e("TAG", response.message().toString());
                    viewPager2.setAdapter(new ProductImagesAdapter(horizontalProductImageList, viewPager2));
                    viewPager2.setClipToPadding(false);
                    viewPager2.setClipChildren(false);
                    viewPager2.setOffscreenPageLimit(3);
                    viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
                    CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
                    compositePageTransformer.addTransformer(new MarginPageTransformer(40));
                    compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
                        @Override
                        public void transformPage(@NonNull View page, float position) {
                            float r = 1 - Math.abs(position);
                            page.setScaleY(0.85f + r * 0.15f);
                        }
                    });

                    viewPager2.setPageTransformer(compositePageTransformer);

                    viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                        @Override
                        public void onPageSelected(int position) {
                            super.onPageSelected(position);
                            sliderHandler.removeCallbacks(sliderRunnable);
                            sliderHandler.postDelayed(sliderRunnable, 5000); // slide duration 2 seconds
                        }
                    });
                }
            }
            @Override
            public void onFailure(Call<ArrayList<HorizontalProductImage>> call, Throwable t) {

            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 1000);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mActivity = getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActivity = null;
    }
}