package com.Mindtree.PlanMyTripServer.Service.Impl;

import com.Mindtree.PlanMyTripServer.Model.UserEntity;
import com.Mindtree.PlanMyTripServer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username+"**Email Id**");
        UserEntity user = this.userRepository.findByUsername(username);
        if(user==null){
            System.out.println("User++ Not Found");
            throw  new UsernameNotFoundException("No user Found!!!");
        }

        return user;
    }


}
