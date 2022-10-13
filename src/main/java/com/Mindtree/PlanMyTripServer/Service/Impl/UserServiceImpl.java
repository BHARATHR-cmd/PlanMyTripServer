package com.Mindtree.PlanMyTripServer.Service.Impl;

import com.Mindtree.PlanMyTripServer.Model.UserEntity;
import com.Mindtree.PlanMyTripServer.Repository.UserRepository;
import com.Mindtree.PlanMyTripServer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserEntity createUser(UserEntity user) throws Exception {
        UserEntity local = this.userRepository.findByUsername(user.getUsername());
        if(local!=null){
            System.out.println("User Already Exits!!!!");
            throw new Exception("User Aleady Present");
        }
            user.setUsername("Default_00000");
            userRepository.save(user);
            user.setUsername(user.getName()+"_"+user.getUserid());
            local=userRepository.save(user);

        return local;

    }

    @Override
    public UserEntity getUser(String username) {
        UserEntity local=this.userRepository.findByUsername(username);
        return local;
    }

    @Override
    public void deleteUser(Long userid) {
        this.userRepository.deleteById(userid);
    }


}
