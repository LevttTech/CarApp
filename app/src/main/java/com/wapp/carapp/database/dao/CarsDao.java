package com.wapp.carapp.database.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.wapp.carapp.models.Car;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.rxjava3.core.Completable;

@Dao
public interface CarsDao {

    @Insert
    Completable insert(Car car);

    @Query("SELECT * FROM cars")
    Single<List<Car>> getCars();

}
