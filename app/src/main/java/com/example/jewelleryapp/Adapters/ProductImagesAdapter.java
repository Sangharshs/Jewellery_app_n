package com.example.jewelleryapp.Adapters;

import static com.example.jewelleryapp.Retrofit.ApiUtils.MAIN_URL;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.jewelleryapp.Model.HorizontalProductImage;
import com.example.jewelleryapp.Model.SliderItem;
import com.example.jewelleryapp.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class ProductImagesAdapter extends  RecyclerView.Adapter<ProductImagesAdapter.SliderAdapterVH> {

private List<HorizontalProductImage> mSliderItems = new ArrayList<>();
private ViewPager2 viewPager2;

public ProductImagesAdapter(List<HorizontalProductImage> mSliderItems, ViewPager2 viewPager2) {
        this.mSliderItems = mSliderItems;
        this.viewPager2 = viewPager2;
        }

@NonNull
@Override
public SliderAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderAdapterVH(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item,
        parent, false));
        }

@Override
public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
        HorizontalProductImage sliderItem = mSliderItems.get(position);

        Glide.with(viewHolder.itemView)
        .load(MAIN_URL+"upload/media/"+sliderItem.getImgpath())
        .fitCenter()
        .into(viewHolder.imageViewBackground);

        if (position == mSliderItems.size() - 2) {
        viewPager2.post(runnable);
        }


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {

        }
        });
        }

@Override
public int getItemCount() {
        return mSliderItems.size();
        }

class SliderAdapterVH extends RecyclerView.ViewHolder {
    View itemView;
    RoundedImageView imageViewBackground;

    public SliderAdapterVH(View itemView) {
        super(itemView);
        imageViewBackground = itemView.findViewById(R.id.imageView);
        this.itemView = itemView;
    }
}

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mSliderItems.addAll(mSliderItems);
            notifyDataSetChanged();
        }
    };
}
