package com.wapp.carapp.database.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

import com.wapp.carapp.models.Brand;

import java.util.List;
import java.util.stream.Collectors;

@Entity(tableName = "brands",indices = {@Index(value = {"brandName"}, unique = true)})
public class BrandEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String brandName;
    public String brandLogo;
    public String brandCountry;

    @Ignore
    public BrandEntity(String brandName, String brandLogo, String brandCountry) {
        this(0, brandName, brandLogo, brandCountry);
    }

    public BrandEntity(int id, String brandName, String brandLogo, String brandCountry) {
        this.id = id;
        this.brandName = brandName;
        this.brandLogo = brandLogo;
        this.brandCountry = brandCountry;
    }
    public static List<Brand> mapToBrands(List<BrandEntity> brandEntities) {
        return brandEntities.stream()
                .map(entity -> new Brand(
                        entity.brandName,
                        entity.brandLogo,
                        entity.brandCountry
                ))
                .collect(Collectors.toList());
    }
    public static List<BrandEntity> toBrandEntity(List<Brand> brands) {
        return brands.stream()
                .map(brand -> new BrandEntity(
                        brand.getBrandName(),
                        brand.getBrandLogo(),
                        brand.getBrandCountry()
                ))
                .collect(Collectors.toList());
    }
}
