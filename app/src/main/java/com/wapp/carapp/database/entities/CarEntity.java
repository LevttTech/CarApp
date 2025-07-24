package com.wapp.carapp.database.entities;

import androidx.room.Entity;
import androidx.room.Index;

import java.util.List;

@Entity(tableName = "cars", indices = {@Index(value = {"modelName"},unique = true)})
public class CarEntity {
    private String modelName;
    private String modelImage;
    private String productionYears;

    private List<String> bodyTypes;
    private List<String> transmissionTypes;
}
