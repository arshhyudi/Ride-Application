package com.Ride.DTO;

public class InputDTO {
    String start;

    String end;

    String date;

    public InputDTO(String start, String end, String date) {
        this.start = start;
        this.end = end;
        this.date = date;
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
}
