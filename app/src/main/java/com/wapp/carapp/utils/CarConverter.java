package com.wapp.carapp.utils;

import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarConverter {
    @TypeConverter
    public String fromBodyTypes(List<String> bodyTypes) {
        return String.join(",", bodyTypes);
    }

    @TypeConverter
    public List<String> toBodyTypes(String bodyTypes) {
        return Arrays.asList(bodyTypes.split(","));
    }
}
