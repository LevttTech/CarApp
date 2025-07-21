package com.wapp.carapp.viewmodels;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.wapp.carapp.api.ApiFactory;
import com.wapp.carapp.models.Brand;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        brandsFromApi -> { brands.setValue(brandsFromApi);},
                        throwable -> {Log.d(TAG,throwable.getMessage());}
                );
        compositeDisposable.add(d);
    }

        @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG,"onCleared()");
        compositeDisposable.dispose();
    }

}
