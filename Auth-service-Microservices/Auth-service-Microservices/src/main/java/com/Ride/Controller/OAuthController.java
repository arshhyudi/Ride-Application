package com.Ride.Controller;


import com.Ride.DAO.AuthDAO;
import com.Ride.Model.AuthModel;
import com.Ride.Service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("oauth")
@CrossOrigin("*")
public class OAuthController {
    @Autowired
    AuthDAO authDAO;


    @Autowired
    OAuthService oAuthService;
    @PostMapping("signup")
    public ResponseEntity<String> registerUser(@RequestBody AuthModel signupData) {
        return oAuthService.signup(signupData);
    }
}
