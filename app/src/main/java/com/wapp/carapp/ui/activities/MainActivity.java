package com.wapp.carapp.ui.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wapp.carapp.R;
import com.wapp.carapp.database.Database;
import com.wapp.carapp.models.Brand;
import com.wapp.carapp.ui.adapters.BrandsAdapter;
import com.wapp.carapp.utils.Utils;
import com.wapp.carapp.viewmodels.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Database database;
    private static final String TAG = "MainActivity";
    private MainViewModel viewModel;
    private BrandsAdapter brandsAdapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        database = Database.getInstance(getApplication());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        brandsAdapter = new BrandsAdapter();
        recyclerView = findViewById(R.id.recyclerViewItems);
        recyclerView.setAdapter(brandsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
        ));

        viewModel.getBrands().observe(this, new Observer<List<Brand>>() {
            @Override
            public void onChanged(List<Brand> brands) {
                brandsAdapter.setItems(brands);
                Log.d(TAG,"changed");
                Utils.dbg(brands);
            }
        });

        viewModel.loadBrands();
    }


}