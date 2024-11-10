package com.Ride.DTO;

import com.Ride.Models.PersonalDetails;

public class GetRideByEmailDTO {
    int rideId;
    String start;
    String end;
    String date;
    String postedEmail;
    String  time;

    int rideAmount;

    PersonalDetails postedBy;

    public GetRideByEmailDTO(int rideId, String start, String end, String date, String postedEmail, String time, int rideAmount, PersonalDetails postedBy) {
        this.rideId = rideId;
        this.start = start;
        this.end = end;
        this.date = date;
        this.postedEmail = postedEmail;
        this.time = time;
        this.rideAmount = rideAmount;
        this.postedBy = postedBy;
    }

    public int getRideId() {
        return rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPostedEmail() {
        return postedEmail;
    }

    public void setPostedEmail(String postedEmail) {
        this.postedEmail = postedEmail;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRideAmount() {
        return rideAmount;
    }

    public void setRideAmount(int rideAmount) {
        this.rideAmount = rideAmount;
    }

    public PersonalDetails getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(PersonalDetails postedBy) {
        this.postedBy = postedBy;
    }
}
