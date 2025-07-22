package com.wapp.carapp.ui.adapters;

import java.util.List;

public interface InterfaceBaseAdapter<T> {
    void updateItems(List<T> items);
    void setOnClickItemListener(OnItemClickListener<T> listener);

    interface OnItemClickListener<T> {
        void onItemClick(T item);
    }


}
