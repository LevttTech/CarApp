package com.wapp.carapp.database;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.wapp.carapp.database.dao.BrandDao;
import com.wapp.carapp.database.entities.BrandEntity;

@androidx.room.Database(entities = {BrandEntity.class}, version = 4,exportSchema = false)
public abstract class Database extends RoomDatabase {
    private static Database instance = null;
    private static final String DB_NAME = "db";
    public abstract BrandDao brandDao();
    public static Database getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    application.getApplicationContext(),
                    Database.class,
                    DB_NAME
            )
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
