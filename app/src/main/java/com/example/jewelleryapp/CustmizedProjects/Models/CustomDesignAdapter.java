package com.example.jewelleryapp.CustmizedProjects.Models;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jewelleryapp.R;
import com.example.jewelleryapp.databinding.ProductSpecificationModelItemBinding;

import java.util.List;

public class CustomDesignAdapter extends RecyclerView.Adapter<CustomDesignAdapter.viewHolder>{
    private List<CustomD_Model> customD_modelList;
    private List<P_SpecificationModel> p_specificationModels;
    private int id;


    public CustomDesignAdapter(List<CustomD_Model> customD_modelList, List<P_SpecificationModel> p_specificationModels,int id) {
        this.customD_modelList = customD_modelList;
        this.p_specificationModels = p_specificationModels;
        this.id = id;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_design_model_item,parent,false);
       return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.textView.setText(customD_modelList.get(position).getDesignName());
        CustomDesItemsAdapter customDesItemsAdapter = new CustomDesItemsAdapter(p_specificationModels,id);
        holder.productSpecificationDesignRecycler.setAdapter(customDesItemsAdapter);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), String.valueOf(customD_modelList.get(position).getId()), Toast.LENGTH_SHORT).show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return customD_modelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private RecyclerView productSpecificationDesignRecycler;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.customDText);
            productSpecificationDesignRecycler = itemView.findViewById(R.id.productSpecificationRecyclerView);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            productSpecificationDesignRecycler.setLayoutManager(linearLayoutManager);
        }
    }
}
