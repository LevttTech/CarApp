package com.wapp.carapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.wapp.carapp.R;
import com.wapp.carapp.models.Car;
import com.wapp.carapp.ui.adapters.CarsAdapter;
import com.wapp.carapp.viewmodels.DetailViewModel;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private DetailViewModel viewModel;
    private String brandName;
    private RecyclerView recyclerView;
    private CarsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        recyclerView = findViewById(R.id.recyclerViewCars);
        adapter = new CarsAdapter();
        recyclerView.setAdapter(adapter);

        brandName = intent.getStringExtra("brand");
        viewModel = new ViewModelProvider(this).get(DetailViewModel.class);

        viewModel.getCars().observe(this, new Observer<List<Car>>() {
            @Override
            public void onChanged(List<Car> cars) {
                Log.d("DetailActivity","changed");
                adapter.updateItems(cars);
            }
        });

        viewModel.loadCarsByBrand(brandName);

    }
}