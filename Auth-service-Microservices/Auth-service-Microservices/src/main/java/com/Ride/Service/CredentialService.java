package com.Ride.Service;

import com.Ride.DAO.AuthDAO;
import com.Ride.DTO.SignInDto;
import com.Ride.Model.AuthModel;
import com.Ride.Model.CredentailsRequestModel;
import com.Ride.Model.PersonalDetailsModel;
import com.Ride.Model.SignInRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class CredentialService {


    @Autowired
    AuthDAO authDAO;

    public  ResponseEntity<SignInDto> signIn(SignInRequestModel requestData) {

        AuthModel userDetails = authDAO.findByEmail(requestData.getEmail());

        if(userDetails==null) return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        if(userDetails.getPassword()!=null && userDetails.getPassword().equals(requestData.getPassword())){
            SignInDto response = new SignInDto(userDetails.getEmail(),userDetails.getName(),userDetails.getImage()==null?"":userDetails.getImage());
            return new ResponseEntity<>(response,HttpStatus.OK);

        }

        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> signupUsingCredentials(@RequestBody CredentailsRequestModel signupCredentails){

        AuthModel isAlreadyExist = authDAO.findByEmail(signupCredentails.getEmail());
        if(isAlreadyExist!=null) return new ResponseEntity<>("Looks Like Already Registered Try Signin", HttpStatus.CONFLICT);
        AuthModel data = new AuthModel(signupCredentails.getName(),signupCredentails.getEmail(),signupCredentails.getPassword());
        PersonalDetailsModel newDetails = new PersonalDetailsModel(signupCredentails.getEmail(),signupCredentails.getGender(),signupCredentails.getName(),signupCredentails.getVehicleNumber(),signupCredentails.getVehicleType(),signupCredentails.getPhonenumber());
        PersonalDetailsModel personalDetails = new RestTemplate().postForObject("http://localhost:8081/personaldetails/add",newDetails, PersonalDetailsModel.class);


        authDAO.save(data);



        return new ResponseEntity<>("User Created", HttpStatus.CREATED);

    }


}
