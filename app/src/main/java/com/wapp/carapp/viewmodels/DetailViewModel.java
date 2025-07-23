package com.wapp.carapp.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.wapp.carapp.api.ApiFactory;
import com.wapp.carapp.models.Car;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DetailViewModel extends AndroidViewModel {
    private static final String TAG ="DetailViewModel";
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<List<Car>> cars = new MutableLiveData();
    public DetailViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<List<Car>> getCars() {
        return cars;
    }

    public void loadCarsByBrand(String brand) {
        Disposable d = ApiFactory.getApiService().getVehicles(brand)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        carsFromApi -> {cars.setValue(carsFromApi);},
                        throwable -> {
                            Log.d(TAG,throwable.getMessage());}
                );
        compositeDisposable.add(d);
    }

}
