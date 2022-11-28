package com.Mindtree.PlanMyTripServer.Repository;

import com.Mindtree.PlanMyTripServer.Model.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepository extends JpaRepository<UserEntity,Long> {
    public UserEntity findByUsername(String username);


    public UserEntity findByEmailId(String emailId);
}
