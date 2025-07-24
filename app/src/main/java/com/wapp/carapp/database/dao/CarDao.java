package com.wapp.carapp.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.wapp.carapp.models.Car;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface CarDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insert(Car car);

    @Query("SELECT * FROM cars")
    Single<List<Car>> getCars();
}
