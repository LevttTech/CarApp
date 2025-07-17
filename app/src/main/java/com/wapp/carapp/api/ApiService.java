package com.wapp.carapp.api;

import com.wapp.carapp.models.Brand;
import com.wapp.carapp.models.Car;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("brands/")
    Single<List<Brand>> getBrands();
}
