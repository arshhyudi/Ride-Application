package com.Ride.DAO;

import com.Ride.Model.AuthModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AuthDAO extends JpaRepository<AuthModel,Integer> {
    public AuthModel findByEmail(String email);

}
