package com.dasturlash.redbook.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


/**
 * Created by QAREKEN on 5/26/2018.
 */
@Entity(tableName = "book")
public class AnimalDbModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "type")
    private int type;

    @ColumnInfo(name = "name_uz")
    private String name_uz;

    @ColumnInfo(name = "name_eng")
    private String name_eng;

    @ColumnInfo(name = "name_rus")
    private String name_rus;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "propagation")
    private String propagation;

    @ColumnInfo(name = "habibat")
    private String habibat;

    @ColumnInfo(name = "numerical")
    private String numerical;

    @ColumnInfo(name = "lifestyle")
    private String lifestyle;

    @ColumnInfo(name = "limiting")
    private String limiting;

    @ColumnInfo(name = "breeding")
    private String breeding;

    @ColumnInfo(name = "security")
    private String security;

    @ColumnInfo(name = "favorite")
    private boolean favorite;

    public String getLimiting() {
        return limiting;
    }

    public void setLimiting(String limiting) {
        this.limiting = limiting;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName_uz() {
        return name_uz;
    }

    public void setName_uz(String name_uz) {
        this.name_uz = name_uz;
    }

    public String getName_eng() {
        return name_eng;
    }

    public void setName_eng(String name_eng) {
        this.name_eng = name_eng;
    }

    public String getName_rus() {
        return name_rus;
    }

    public void setName_rus(String name_rus) {
        this.name_rus = name_rus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPropagation() {
        return propagation;
    }

    public void setPropagation(String propagation) {
        this.propagation = propagation;
    }

    public String getHabibat() {
        return habibat;
    }

    public void setHabibat(String habibat) {
        this.habibat = habibat;
    }

    public String getNumerical() {
        return numerical;
    }

    public void setNumerical(String numerical) {
        this.numerical = numerical;
    }

    public String getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(String lifestyle) {
        this.lifestyle = lifestyle;
    }

    public String getBreeding() {
        return breeding;
    }

    public void setBreeding(String breeding) {
        this.breeding = breeding;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

}
