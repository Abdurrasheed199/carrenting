package com.rent.carrenting.models.showmodels;

import com.rent.carrenting.models.Branch;
import com.rent.carrenting.models.Car;

import java.util.Date;

public class RegisterBookingModel {

    private Branch branch;


    private Car car;

    private String bookingNumber;

    private Date bookingDate;

    private String bookingRef;

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(String bookingRef) {
        this.bookingRef = bookingRef;
    }
}
