package com.wapp.carapp.ui.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wapp.carapp.R;
import com.wapp.carapp.models.Brand;

import java.util.List;

public class BrandsAdapter extends BaseAdapter<Brand> {

    @Override
    protected ViewHolder<Brand> createViewHolder(View view) {
        return new BrandViewHolder(view, getListener(), getItems());
    }

    @Override
    protected void bindView(ViewHolder<Brand> holder, Brand item) {
        BrandViewHolder brandHolder = (BrandViewHolder) holder;
        brandHolder.textViewBrand.setText(item.getBrandName());
        brandHolder.textViewCountry.setText(item.getBrandCountry());
        Glide.with(brandHolder.imageView.getContext())
                .load(item.getBrandLogo())
                .into(brandHolder.imageView);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.brand_item;
    }

    public class BrandViewHolder extends BaseAdapter.ViewHolder<Brand> {
        private TextView textViewBrand;
        private TextView textViewCountry;
        private ImageView imageView;
        private final OnItemClickListener<Brand> listener;
        private final List<Brand> items;

        public BrandViewHolder(@NonNull View itemView, OnItemClickListener<Brand> listener, List<Brand> items) {
            super(itemView);
            this.listener = listener;
            this.items = items;

            textViewBrand = itemView.findViewById(R.id.textViewTitle);
            textViewCountry = itemView.findViewById(R.id.textViewCountry);
            imageView = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(v -> {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION && listener != null) {
                    listener.onItemClick(items.get(pos));
                }
            });
        }

        @Override
        public void bind(Brand item) {
            bindView(this, item);
        }
    }
}