package com.wapp.carapp.ui.adapters;

import android.widget.AdapterView;

import java.util.List;

public interface IRecyclerViewAdapter<T> {
    void updateItems(List<T> items);
    void setOnClickItemListener(OnItemClickListener<T> listener);

    interface OnItemClickListener<T> {
        void onItemClick(T item);
    }


}
