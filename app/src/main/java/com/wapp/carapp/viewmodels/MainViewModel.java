package com.wapp.carapp.viewmodels;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.wapp.carapp.api.ApiFactory;
import com.wapp.carapp.database.Database;
import com.wapp.carapp.database.entities.BrandEntity;
import com.wapp.carapp.models.Brand;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG ="MainViewModel";
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<Brand>> brands = new MutableLiveData();
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Brand>> getBrands() {
        return brands;
    }

    public void loadBrands() {
        Disposable d = ApiFactory.getApiService().getBrands()
                .doOnSuccess((brandsFromApi) -> {
                    List<BrandEntity> brandEntities = toBrandEntity(brandsFromApi);
                    Log.d(TAG,"cur thread:" + Thread.currentThread().getName());
                    Database.getInstance(getApplication()).brandDao().insertBrands(
                    brandEntities
                    ).subscribe();
                })
                .doOnTerminate(()-> {
                    Log.d(TAG,"afterterminate THREAD="+Thread.currentThread().getName());
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        brandsFromApi -> {
                            Log.d(TAG,"Onsuccses() thread="+Thread.currentThread().getName());
                            brands.setValue(brandsFromApi);},
                        throwable -> {
                            Log.d(TAG,throwable.getMessage());
                            Database.getInstance(getApplication()).brandDao().getBrands()
                                    .observeOn(AndroidSchedulers.mainThread())
                                                    .subscribe(brandEntities -> {
                                                        Log.d(TAG,"thread in rxjava:" + Thread.currentThread().getName());
                                                        brands.setValue(mapToBrands(brandEntities));
                                                    });
                            Log.d(TAG,"thread in error:" + Thread.currentThread().getName());

                        }
                );
        compositeDisposable.add(d);
    }
    private List<Brand> mapToBrands(List<BrandEntity> brandEntities) {
        return brandEntities.stream()
                .map(entity -> new Brand(
                        entity.brandName,
                        entity.brandLogo,
                        entity.brandCountry
                ))
                .collect(Collectors.toList());
    }
    private List<BrandEntity> toBrandEntity(List<Brand> brands) {
        return brands.stream()
                .map(brand -> new BrandEntity(
                        brand.getBrandName(),
                        brand.getBrandLogo(),
                        brand.getBrandCountry()
                ))
                .collect(Collectors.toList());
    }

        @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG,"onCleared()");
        compositeDisposable.dispose();
    }

}
