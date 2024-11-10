package com.Ride.Controllers;

import com.Ride.DTO.InputDTO;
import com.Ride.Models.RideModel;
import com.Ride.Services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController {
    @Autowired
    SearchService searchService;


    @PostMapping("/")
    public ResponseEntity<List<RideModel>> search(@RequestBody InputDTO input){
        try{
            return searchService.searchrides(input);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
