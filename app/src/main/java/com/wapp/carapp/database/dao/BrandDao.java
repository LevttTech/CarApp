package com.wapp.carapp.database.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.wapp.carapp.database.entities.BrandEntity;
import com.wapp.carapp.models.Brand;
import com.wapp.carapp.models.Car;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface BrandDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insert(BrandEntity brand);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insertBrands(List<BrandEntity> brands);

    @Query("SELECT * FROM brands")
    Single<List<BrandEntity>> getBrands();

}
