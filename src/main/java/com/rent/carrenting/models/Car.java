package com.rent.carrenting.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String make;

    @NotNull
    private String name;

    @NotNull
    private String model;

    @NotNull
    private String plateNo;

    @NotNull
    private String features;

    @NotNull
    private String breakdownPrice;

    @ManyToOne
    private Branch branch;

    @NotNull
    private String registrationNumber;

    @ManyToOne
    private Category category;

    @NotNull
    private Double price;

    private Boolean isAvailable;

    private String url;

    public Car(){

    }

    public Car(String make, String name, String model, String plateNo, String features, String breakdownPrice, Branch branch, String registrationNumber, Category category, Double price, Boolean isAvailable, String url) {
        this.make = make;
        this.name = name;
        this.model = model;
        this.plateNo = plateNo;
        this.features = features;
        this.breakdownPrice = breakdownPrice;
        this.branch = branch;
        this.registrationNumber = registrationNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = isAvailable;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

