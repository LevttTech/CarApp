package com.wapp.carapp.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "brands")
public class BrandEntity {
    @PrimaryKey
    public int id;
    public String brandName;
    public String brandLogo;
    public String brandCountry;


}
