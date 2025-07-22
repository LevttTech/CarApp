package com.wapp.carapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ViewHolder<T>>
        implements InterfaceBaseAdapter<T> {

    private List<T> items = new ArrayList<>();
    private OnItemClickListener<T> listener;

    public List<T> getItems() {
        return items;
    }

    public OnItemClickListener<T> getListener() {
        return listener;
    }

    @Override
    public void updateItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public void setOnClickItemListener(OnItemClickListener<T> listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder<T> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(getItemLayout(), parent, false);
        return createViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder<T> holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected abstract ViewHolder<T> createViewHolder(View view);


    protected abstract void bindView(ViewHolder<T> holder, T item);


    protected abstract int getItemLayout();

    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        public abstract void bind(T item);
    }
}