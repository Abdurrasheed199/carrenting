package com.rent.carrenting.models.showmodels;

import com.rent.carrenting.models.Branch;
import com.rent.carrenting.models.Category;
import com.sun.istack.NotNull;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.ManyToOne;

public class RegisterCarModel {

    private String make;


    private String name;


    private String model;


    private String plateNo;

    private String features;

    private String breakdownPrice;

    private Branch branch;

    private String registrationNumber;

    private String categoryName;

    private Double price;


    private MultipartFile url;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getBreakdownPrice() {
        return breakdownPrice;
    }

    public void setBreakdownPrice(String breakdownPrice) {
        this.breakdownPrice = breakdownPrice;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public MultipartFile getUrl() {
        return url;
    }

    public void setUrl(MultipartFile url) {
        this.url = url;
    }
}
