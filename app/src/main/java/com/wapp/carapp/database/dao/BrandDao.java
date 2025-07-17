package com.wapp.carapp.database.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.wapp.carapp.database.entities.BrandEntity;
import com.wapp.carapp.models.Brand;
import com.wapp.carapp.models.Car;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface BrandDao {

    @Insert
    Completable insert(BrandEntity brand);

    @Query("SELECT * FROM brands")
    Single<List<BrandEntity>> getBrands();

}
