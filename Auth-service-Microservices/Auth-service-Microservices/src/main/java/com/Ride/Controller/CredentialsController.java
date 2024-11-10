package com.Ride.Controller;

import com.Ride.DTO.SignInDto;
import com.Ride.Model.CredentailsRequestModel;
import com.Ride.Model.SignInRequestModel;
import com.Ride.Service.CredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/credentials")
public class CredentialsController {
    @Autowired
    CredentialService credentialService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody CredentailsRequestModel input){
        return credentialService.signupUsingCredentials(input);
    }


    @PostMapping("/signin")
    public ResponseEntity<SignInDto> signIn(@RequestBody SignInRequestModel requestData){
        return credentialService.signIn(requestData);
    }
}
