package com.Ride.BookingMicroservices.DAO;

import com.Ride.BookingMicroservices.Models.BookingsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingDAO extends JpaRepository<BookingsModel, Integer> {

    @Query(value = "select * from bookings_model where posted_email=:postedEmail and ride_id=:rideId and user_email =:userEmail limit 1",nativeQuery = true)
    public BookingsModel findIsAlreadyExists(String postedEmail,String rideId,String userEmail);
}
