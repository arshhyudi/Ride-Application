package com.Ride.Services;

import com.Ride.DAO.RideDAO;
import com.Ride.DTO.GetRideByEmailDTO;
import com.Ride.Models.PersonalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class RideService {

    @Autowired
    RideDAO rideDAO;

    public ResponseEntity<String> addRide(PersonalDetails inputModel){

        try{
            rideDAO.save(inputModel);

            return new ResponseEntity<>("Ride sucessfully posted", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }



    }

    public ResponseEntity<List<PersonalDetails>> getAllUserRides(String email){
        try {
            List<PersonalDetails> li = rideDAO.findAllByPostedEmail(email);
            return new ResponseEntity<>(li,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }


    public  ResponseEntity<GetRideByEmailDTO> getRideDetailsByid(int id){
        try {
            PersonalDetails foundRide = rideDAO.findById(id);

            PersonalDetails ridePosterDetails = new RestTemplate().getForObject("http://localhost:8081/personaldetails/getdetailsByEmail?email="+foundRide.getPostedEmail(), PersonalDetails.class);

            GetRideByEmailDTO response = new GetRideByEmailDTO(foundRide.getRideId(), foundRide.getStart(),  foundRide.getEnd(),foundRide.getDate(), foundRide.getPostedEmail(), foundRide.getTime(), foundRide.getRideAmount(),ridePosterDetails);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

    }
}
