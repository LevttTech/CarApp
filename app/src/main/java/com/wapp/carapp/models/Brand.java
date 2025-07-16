package com.wapp.carapp.models;

public class Brand {
    private String brandName;
    private String brandLogo;
    private String brandCountry;


    public Brand(String brandName, String brandLogo, String brandCountry) {
        this.brandName = brandName;
        this.brandLogo = brandLogo;
        this.brandCountry = brandCountry;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandCountry() {
        return brandCountry;
    }

    public void setBrandCountry(String brandCountry) {
        this.brandCountry = brandCountry;
    }
}
