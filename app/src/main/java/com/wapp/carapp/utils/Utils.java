package com.wapp.carapp.utils;

import android.util.Log;

import com.wapp.carapp.models.Brand;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String BASE_URL = "https://mobile-apps-programming-labs.firebaseapp.com/task3/";
    public static void dbg(List<Brand> brands) {
        for (Brand brand : brands) {
            Log.d("MainViewModel",String.format("brandName = %s" +
                            "|" +
                    "brandLogo = %s" +
                            "|" +
                    "brandCountry = %s",
                    brand.getBrandName(),
                    brand.getBrandLogo(),
                    brand.getBrandCountry()));
        }
    }
}
