package com.Ride.Services;

import com.Ride.DAO.PersonalControllerDao;
import com.Ride.Models.PersonalDetailsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonalDetailsService {
    @Autowired
    PersonalControllerDao personalControllerDao;

    public ResponseEntity<PersonalDetailsModel> add(PersonalDetailsModel requestData) {


        try{
            PersonalDetailsModel response = personalControllerDao.save(requestData);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }


    }

    public ResponseEntity<PersonalDetailsModel> findByEmail(String email) {

        try{

            return new ResponseEntity<> (personalControllerDao.findOneByEmail(email),HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<PersonalDetailsModel> getDetailsUsingEmail(String email){
        try{
            PersonalDetailsModel result = (PersonalDetailsModel) personalControllerDao.findOneByEmail(email);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

    }
}
