package com.Mindtree.PlanMyTripServer.Service;

import com.Mindtree.PlanMyTripServer.Model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public UserEntity createUser(UserEntity user) throws Exception;
    public UserEntity getUser(String username);
    public void deleteUser(Long userid);


}
