package com.wapp.carapp.ui.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wapp.carapp.R;
import com.wapp.carapp.models.Item;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter {

    private ArrayList<Item> items = new ArrayList<>();

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class ItemsViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle, textViewCountry;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewCountry = itemView.findViewById(R.id.textViewCountry);
        }

    }


}
