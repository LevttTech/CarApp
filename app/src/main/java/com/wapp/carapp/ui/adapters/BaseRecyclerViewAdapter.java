package com.wapp.carapp.ui.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wapp.carapp.R;
import com.wapp.carapp.models.Car;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T>
        extends RecyclerView.Adapter<BaseRecyclerViewAdapter<T>.ViewHolder>
        implements IRecyclerViewAdapter<T> {

    private List<T> items = new ArrayList<>();
    private OnItemClickListener<T> listener;

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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(
                        getItemLayout(),
                        parent,
                        false
                );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected abstract void bindView(View view, T item);
    protected abstract int getItemLayout();
    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(items.get(pos));
                    }
                }
            });
        }

        public void bind(T item) {
            bindView(itemView, item);
        }
    }
}
