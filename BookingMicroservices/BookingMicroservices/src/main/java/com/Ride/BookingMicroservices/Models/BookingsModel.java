package com.Ride.BookingMicroservices.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BookingsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String userEmail;

    String postedEmail;

    String rideId;

    String status;


    public BookingsModel(String userEmail, String postedEmail, String rideId, String status) {
        this.userEmail = userEmail;
        this.postedEmail = postedEmail;
        this.rideId = rideId;
        this.status = status;
    }

    public BookingsModel() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPostedEmail() {
        return postedEmail;
    }

    public void setPostedEmail(String postedEmail) {
        this.postedEmail = postedEmail;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
