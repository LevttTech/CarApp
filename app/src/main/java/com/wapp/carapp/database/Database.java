package com.wapp.carapp.database;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.wapp.carapp.database.dao.BrandDao;
import com.wapp.carapp.database.dao.CarDao;
import com.wapp.carapp.database.entities.BrandEntity;
import com.wapp.carapp.database.entities.CarEntity;
import com.wapp.carapp.utils.CarConverter;


@androidx.room.Database(entities = {BrandEntity.class, CarEntity.class}, version = 5,exportSchema = false)
@TypeConverters({CarConverter.class})
public abstract class Database extends RoomDatabase {
    private static Database instance = null;
    private static final String DB_NAME = "db";
    public abstract BrandDao brandDao();
    public abstract CarDao carDao();

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
