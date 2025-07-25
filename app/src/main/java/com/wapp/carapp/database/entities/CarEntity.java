package com.wapp.carapp.database.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import com.wapp.carapp.models.Brand;
import com.wapp.carapp.models.Car;
import com.wapp.carapp.utils.CarConverter;

import java.util.List;
import java.util.stream.Collectors;

@Entity(tableName = "cars", indices = {@Index(value = {"modelName"},unique = true)})
public class CarEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String modelName;
    public String brandName;
    public String modelImage;
    public String productionYears;

    public List<String> bodyTypes;
    public List<String> transmissionTypes;


    @Ignore
    public CarEntity(String modelName,String modelImage, String productionYears,
                     List<String> bodyTypes, List<String> transmissionTypes,String brandName) {
        this(0, modelName,modelImage,productionYears,bodyTypes,transmissionTypes,brandName);
    }

    public CarEntity(int id, String modelName, String modelImage, String productionYears,
                     List<String> bodyTypes, List<String> transmissionTypes,String brandName) {
        this.id = id;
        this.modelName = modelName;
        this.modelImage = modelImage;
        this.productionYears = productionYears;
        this.bodyTypes = bodyTypes;
        this.transmissionTypes = transmissionTypes;
        this.brandName = brandName;
    }

    public static List<Car> mapToCars(List<CarEntity> carEntities) {
        return carEntities.stream()
                .map(entity -> new Car(
                        entity.modelName,
                        entity.modelImage,
                        entity.productionYears,
                        entity.bodyTypes,
                        entity.transmissionTypes,
                        entity.brandName
                ))
                .collect(Collectors.toList());
    }
    public static List<CarEntity> toCarEntity(List<Car> cars) {
        return cars.stream()
                .map(car -> new CarEntity(
                        car.getModelName(),
                        car.getModelImage(),
                        car.getProductionYears(),
                        car.getBodyTypes(),
                        car.getTransmissionTypes(),
                        car.getBrandName()
                ))
                .collect(Collectors.toList());
    }
}
