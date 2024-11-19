package com.model;

public class BookingResponse {
	private float fare;         
    private String message;      

 
    public BookingResponse(float fare, String message) {
        this.fare = fare;
        this.message = message;
    }


    public float getFare() {
        return fare;
    }

    public void setFare(float fare) {
        this.fare = fare;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
