package com.wapp.carapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wapp.carapp.R;
import com.wapp.carapp.models.Brand;
import com.wapp.carapp.models.Car;

import java.util.ArrayList;
import java.util.List;

public class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.ItemsViewHolder> {

    private List<Brand> brands = new ArrayList<>();

    public void setItems(List<Brand> brands) {
        this.brands = brands;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BrandsAdapter.ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent, false);
        return new ItemsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {
        holder.onBind(brands.get(position));
    }

    @Override
    public int getItemCount() {
        return brands.size();
    }

// why static?!
    static class ItemsViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle, textViewCountry;
        private ImageView imageView;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewCountry = itemView.findViewById(R.id.textViewCountry);
            imageView = itemView.findViewById(R.id.imageView);
        }

        public void onBind(Brand brand) {
            textViewTitle.setText(brand.getBrandName());
            textViewCountry.setText(brand.getBrandCountry());
            Glide.with(itemView.getContext())
                    .load(brand.getBrandLogo())
                    .into(imageView);
        }
    }


}
