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

    @PutMapping("/{userid}")
    public UserEntity updateUser(@RequestBody UserEntity newUserEntity,@PathVariable Long userid) throws Exception {
        UserEntity userEntity=this.userRepository.findById(userid).get();
        if(this.userService.getUser(newUserEntity.getUsername())!=null){
            userEntity.setName(newUserEntity.getName());
            userEntity.setPhone(newUserEntity.getPhone());
            userEntity.setProfilepic(newUserEntity.getProfilepic());
            userEntity.setEmailId(newUserEntity.getEmailId());
            userEntity.setPassword(newUserEntity.getPassword());
            return userRepository.save(userEntity);
        }
        else {
            System.out.println("User Does Not Exits!!!");
            throw new Exception("User Does Not Exits!!!");
        }


    }
}
