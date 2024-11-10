package com.Ride.BookingMicroservices.Service;

import com.Ride.BookingMicroservices.DAO.BookingDAO;
import com.Ride.BookingMicroservices.Models.BookingsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    BookingDAO bookingDAO;
    public ResponseEntity<String> addBooking(BookingsModel input){
        try{

            input.setStatus("Awaiting Approval");

            if(input.getPostedEmail().equals(input.getUserEmail()))
                return new ResponseEntity<>("You can't book the rides you posted",HttpStatus.BAD_REQUEST);

            BookingsModel isAlreadyBooked = bookingDAO.findIsAlreadyExists(input.getPostedEmail(),input.getRideId(),input.getUserEmail());
            if (isAlreadyBooked!=null) return new ResponseEntity<>("Cool!! Your booking is confirmed",HttpStatus.CONFLICT);

            bookingDAO.save(input);
            return new ResponseEntity<>("Booking Added Sucessfully", HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<String> approveBooking(int id) {
        try{


            BookingsModel Booking = bookingDAO.findById(id).get();


            if(Booking.getStatus().equals("Approved")) return new ResponseEntity<>("Booking Already Approved",HttpStatus.CONFLICT);

            Booking.setStatus("Approved");

            bookingDAO.save(Booking);
            return new ResponseEntity<>("Booking Approved",HttpStatus.CONFLICT);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

    }
}
