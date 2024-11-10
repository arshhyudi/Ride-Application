package com.Ride.DAO;

import com.Ride.Models.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RideDAO extends JpaRepository<PersonalDetails,Integer> {
    public List<PersonalDetails> findAllByPostedEmail(String email);

    public PersonalDetails findById(int id);
}
