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

    @ColumnInfo(name = "nameUzb")
    private String nameUzb;

    @ColumnInfo(name = "nameEng")
    private String nameEng;

    @ColumnInfo(name = "nameRus")
    private String nameRus;

    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "propagation")
    private String propagation;

    @ColumnInfo(name = "habitat")
    private String habitat;

    @ColumnInfo(name = "quantity")
    private String quantity;

    @ColumnInfo(name = "lifestyle")
    private String lifestyle;

    @ColumnInfo(name = "limitingFactors")
    private String limitingFactors;

    @ColumnInfo(name = "breeding")
    private String breeding;

    @ColumnInfo(name = "security")
    private String security;

    @ColumnInfo(name = "favorite")
    private boolean favorite;

    public String getLimitingFactors() {
        return limitingFactors;
    }

    public void setLimitingFactors(String limitingFactors) {
        this.limitingFactors = limitingFactors;
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

    public String getNameUzb() {
        return nameUzb;
    }

    public void setNameUzb(String nameUzb) {
        this.nameUzb = nameUzb;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getNameRus() {
        return nameRus;
    }

    public void setNameRus(String nameRus) {
        this.nameRus = nameRus;
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

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
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
