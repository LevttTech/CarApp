package com.wapp.carapp.database.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "cars", indices = {@Index(value = {"modelName"},unique = true)})
public class CarEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String modelName;
    private String modelImage;
    private String productionYears;

    private List<String> bodyTypes;
    private List<String> transmissionTypes;

    @Ignore
    public CarEntity(String modelName,String modelImage, String productionYears,
                     List<String> bodyTypes, List<String> transmissionTypes) {
        this(0, modelName,modelImage,productionYears,bodyTypes,transmissionTypes);
    }

    public CarEntity(int id, String modelName, String modelImage, String productionYears,
                     List<String> bodyTypes, List<String> transmissionTypes) {
        this.id = id;
        this.modelName = modelName;
        this.modelImage = modelImage;
        this.productionYears = productionYears;
        this.bodyTypes = bodyTypes;
        this.transmissionTypes = transmissionTypes;
    }

}
