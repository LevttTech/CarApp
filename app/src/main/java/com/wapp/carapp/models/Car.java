package com.wapp.carapp.models;

import java.util.List;

public class Car {

    private String modelName;
    private String modelImage;
    private String productionYears;

    private List<String> bodyTypes;
    private List<String> transmissionTypes;
    private String brandName;

    public Car(String modelName, String modelImage, String productionYears, List<String> bodyTypes, List<String> transmissionTypes,
               String brandName) {
        this.modelName = modelName;
        this.modelImage = modelImage;
        this.productionYears = productionYears;
        this.bodyTypes = bodyTypes;
        this.transmissionTypes = transmissionTypes;
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelImage() {
        return modelImage;
    }

    public void setModelImage(String modelImage) {
        this.modelImage = modelImage;
    }

    public String getProductionYears() {
        return productionYears;
    }

    public void setProductionYears(String productionYears) {
        this.productionYears = productionYears;
    }

    public List<String> getBodyTypes() {
        return bodyTypes;
    }

    public void setBodyTypes(List<String> bodyTypes) {
        this.bodyTypes = bodyTypes;
    }

    public List<String> getTransmissionTypes() {
        return transmissionTypes;
    }

    public void setTransmissionTypes(List<String> transmissionTypes) {
        this.transmissionTypes = transmissionTypes;
    }
}
