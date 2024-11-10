package com.Ride.BookingMicroservices.Controllers;

import com.Ride.BookingMicroservices.Models.BookingsModel;
import com.Ride.BookingMicroservices.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booking")
public class BookingController {
    @Autowired
     BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<String> addbooking(@RequestBody BookingsModel input) {

        try {
            return bookingService.addBooking(input);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @PatchMapping("/approveRide")
    public ResponseEntity<String> approveBooking(@RequestParam int id){
        return bookingService.approveBooking(id);

    }
}
