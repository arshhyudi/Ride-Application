package com.Ride.Service;

import com.Ride.DAO.AuthDAO;
import com.Ride.Model.AuthModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OAuthService {
    @Autowired
    AuthDAO authDAO;


    public ResponseEntity<String> signup(AuthModel signupData) {
        try{
            AuthModel isAlreadyExist = authDAO.findByEmail(signupData.getEmail());
            if(isAlreadyExist==null){
                boolean isEmailVerified = signupData.getType().equals("oauth")?true:false;
                AuthModel model = new AuthModel(signupData.getName(),signupData.getEmail(), signupData.getImage(), signupData.getProvider(),signupData.getType(),isEmailVerified);

                AuthModel response = authDAO.save(model);
                return new ResponseEntity<>("User Created", HttpStatus.OK);
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>("User Created", HttpStatus.OK);
    }
}
