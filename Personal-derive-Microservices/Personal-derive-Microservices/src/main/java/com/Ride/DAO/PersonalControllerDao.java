package com.Ride.DAO;

import com.Ride.Models.PersonalDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PersonalControllerDao extends JpaRepository<PersonalDetailsModel, String> {
    public PersonalDetailsModel findOneByEmail(String email);
}

