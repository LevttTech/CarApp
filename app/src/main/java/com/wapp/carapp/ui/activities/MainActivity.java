package com.wapp.carapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wapp.carapp.R;
import com.wapp.carapp.database.Database;
import com.wapp.carapp.models.Brand;
import com.wapp.carapp.ui.adapters.BrandsAdapter;
import com.wapp.carapp.ui.adapters.CarsAdapter;
import com.wapp.carapp.ui.adapters.InterfaceBaseAdapter;
import com.wapp.carapp.utils.Utils;
import com.wapp.carapp.viewmodels.MainViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MainViewModel viewModel;
    private BrandsAdapter brandsAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initViews();
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        brandsAdapter = new BrandsAdapter();
        brandsAdapter.setOnClickItemListener(new InterfaceBaseAdapter.OnItemClickListener<Brand>() {
            @Override
            public void onItemClick(Brand item) {
                startDetailActivity(item.getBrandName());
            }
        });
        recyclerViewSettings();



        viewModel.getBrands().observe(this, new Observer<List<Brand>>() {
            @Override
            public void onChanged(List<Brand> brands) {
                brandsAdapter.updateItems(brands);
            }
        });

        viewModel.loadBrands();
    }

    private void recyclerViewSettings() {
        recyclerView.setAdapter(brandsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));
    }
    private void initViews() {
        recyclerView = findViewById(R.id.recyclerViewItems);
    }

    private void startDetailActivity(String brandName) {
        Intent intent = DetailActivity.newIntent(this, brandName);
        startActivity(intent);
    }
}