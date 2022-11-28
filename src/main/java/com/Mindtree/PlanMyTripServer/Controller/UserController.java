package com.Mindtree.PlanMyTripServer.Controller;

import com.Mindtree.PlanMyTripServer.Model.UserEntity;
import com.Mindtree.PlanMyTripServer.Repository.UserRepository;
import com.Mindtree.PlanMyTripServer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
//@Controller

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/")
    public UserEntity createUser(@RequestBody UserEntity userEntity) throws Exception {
        userEntity.setPassword(this.bCryptPasswordEncoder.encode(userEntity.getPassword()));


        return this.userService.createUser(userEntity);
    }
    @GetMapping("/{username}")
    public UserEntity getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }


    @DeleteMapping("/{userid}")
    public void deleteUser(@PathVariable("userid") Long userid){
        this.userService.deleteUser(userid);
    }

    @PutMapping("/")
    public UserEntity updateUser(@RequestBody UserEntity updatedUserEntity) throws Exception {


//            updatedUserEntity.setPassword(this.bCryptPasswordEncoder.encode(updatedUserEntity.getPassword()));

            return this.userService.updateUser(updatedUserEntity);




    }
}
