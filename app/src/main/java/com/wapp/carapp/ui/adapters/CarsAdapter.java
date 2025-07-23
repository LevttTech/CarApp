package com.wapp.carapp.ui.adapters;

import android.content.Context;
import android.media.Image;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.wapp.carapp.R;
import com.wapp.carapp.models.Car;

import java.util.List;

public class CarsAdapter extends BaseAdapter<Car>{
    @Override
    protected ViewHolder<Car> createViewHolder(View view) {
        return new CarViewHolder(view, getListener(), getItems());
    }

    @Override
    protected void bindView(ViewHolder<Car> holder, Car item) {
        Context context = holder.itemView.getContext();
        CarViewHolder carHolder = (CarViewHolder) holder;
        carHolder.productionYear.setText(context.getString
                (R.string.years_with_prefix,item.getProductionYears()));
        carHolder.textViewModelName.setText(context.getString(
                R.string.model_with_prefix,item.getModelName()));
        carHolder.transmissionTypes.setText(context.getString(
                R.string.transmission_with_prefix,
                TextUtils.join(", ",item.getTransmissionTypes())));
        carHolder.bodyTypes.setText(context.getString(
                R.string.body_with_prefix,
                TextUtils.join(", ", item.getBodyTypes())));
        Glide.with(holder.itemView)
                .load(item.getModelImage())
                .into(carHolder.modelImage);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.car_item;
    }

    public class CarViewHolder extends ViewHolder<Car> {

        private TextView textViewModelName;
        private TextView productionYear;
        private ImageView modelImage;
        private TextView bodyTypes;
        private TextView transmissionTypes;

        public final List<Car> items;
        public final OnItemClickListener<Car> listener;
        public CarViewHolder(@NonNull View itemView, OnItemClickListener<Car> listener, List<Car> items) {
            super(itemView);

            this.items = items;
            this.listener = listener;
            textViewModelName = itemView.findViewById(R.id.textViewModelName);
            productionYear = itemView.findViewById(R.id.textViewProductionYears);
            modelImage = itemView.findViewById(R.id.imageView);
            bodyTypes = itemView.findViewById(R.id.textViewBodyTypes);
            transmissionTypes = itemView.findViewById(R.id.textViewTransmissionTypes);


            itemView.setOnClickListener(new View.OnClickListener() {
                int pos = getAdapterPosition();
                @Override
                public void onClick(View v) {
                    if (pos != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(items.get(pos));
                    }
                }
            });
        }

        @Override
        public void bind(Car item) {
            bindView(this, item);
        }
    }
}
