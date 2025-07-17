package com.wapp.carapp.ui.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.wapp.carapp.R;
import com.wapp.carapp.database.Database;

public class MainActivity extends AppCompatActivity {
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        database = Database.getInstance(getApplication());
    }



}