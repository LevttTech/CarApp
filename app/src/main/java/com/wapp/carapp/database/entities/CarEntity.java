package com.wapp.carapp.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "cars")
public class CarEntity {
    @PrimaryKey
    public int id;
    private String modelName;
    private String modelImage;
    private String productionYears;

    private List<String> bodyTypes;
    private List<String> transmissionTypes;

}
