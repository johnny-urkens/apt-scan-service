package com.example.scanservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "scans")
public class Scan {
    @Id
    private String id;
    private String userName;
    private String carBrand;
    private Integer scoreNumber;

    public Scan() {
    }

    public Scan(String userName, String carBrand, Integer scoreNumber) {
        this.userName = userName.toUpperCase();
        this.carBrand = carBrand;
        this.scoreNumber = scoreNumber;
    }

    public String getUserName() {
        return userName.substring(0, 1).toUpperCase() + userName.substring(1).toLowerCase();
    }

    public void setUserName(String userName) {
        this.userName = userName.toUpperCase();
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public Integer getScoreNumber() {
        return scoreNumber;
    }

    public void setScoreNumber(Integer scoreNumber) {
        this.scoreNumber = scoreNumber;
    }

}
