package com.wapp.carapp.ui.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wapp.carapp.R;
import com.wapp.carapp.models.Brand;

public class BrandAdapter extends BaseAdapter<Brand> {


    @Override
    protected void bindView(View view, Brand item) {
        TextView nameView = view.findViewById(R.id.textViewTitle);
        TextView countryView = view.findViewById(R.id.textViewCountry);
        ImageView logoView = view.findViewById(R.id.imageView);

        nameView.setText(item.getBrandName());
        countryView.setText(item.getBrandCountry());
        Glide.with(view.getContext())
                .load(item.getBrandLogo())
                .into(logoView);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.brand_item;
    }
}
