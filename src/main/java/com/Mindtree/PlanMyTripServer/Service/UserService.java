package com.Mindtree.PlanMyTripServer.Service;

import com.Mindtree.PlanMyTripServer.Model.UserEntity;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public interface UserService {

    public UserEntity createUser(UserEntity user) throws Exception;
    public UserEntity getUser(String username);
    public UserEntity updateUser(UserEntity user) throws MessagingException;
    public void deleteUser(Long userid);


}
