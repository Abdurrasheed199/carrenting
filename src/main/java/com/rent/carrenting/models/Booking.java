package com.rent.carrenting.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Branch branch;

    @ManyToOne
    private User user;

    @ManyToOne
    private Car car;

    private String bookingNumber;

    private Date bookingDate;

    private String bookingRef;

    public Booking(){

    }

    public Booking(Branch branch, User user, Car car, String bookingNumber, Date bookingDate, String bookingRef) {
        this.branch = branch;
        this.user = user;
        this.car = car;
        this.bookingNumber = bookingNumber;
        this.bookingDate = bookingDate;
        this.bookingRef = bookingRef;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
