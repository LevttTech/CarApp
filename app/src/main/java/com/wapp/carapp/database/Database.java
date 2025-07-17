package com.wapp.carapp.database;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.wapp.carapp.database.dao.CarsDao;
import com.wapp.carapp.database.entities.CarEntity;

@androidx.room.Database(entities = {CarEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {
    private static Database instance = null;
    private static final String DB_NAME = "db";
    public abstract CarsDao carsDao();
    public static Database getInstance(Application application) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    application.getApplicationContext(),
                    Database.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }

}
