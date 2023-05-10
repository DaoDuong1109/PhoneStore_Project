package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.model.dto.user.CheckInDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/findAll")
    public List<UserEntity> findAll(){return service.getUsers();}
    @GetMapping("/findById/{id}")
    public UserEntity findById(@PathVariable int id){
        return service.getById(id);
    }
    @PutMapping("/updateUserByEmail")
    public UserEntity updateUserByEmail(@RequestParam String email, @RequestBody UserEntity user){
        return service.updateUserByEmail(email, user);
    }
    @PutMapping("/updateUserById/{id}")
    public UserEntity updateUserById(@PathVariable int id, @RequestBody UserEntity user){
        return service.updateUserById(id, user);
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteSlideById(@PathVariable int id){
        return service.delete(id);
    }
    @PostMapping("/checkin")
    public UserEntity checkin(@RequestParam("username") String username, @RequestParam("password") String password){
        return service.GetUserByEmailPass(username, password);
    }
    @PostMapping("/createUser")
    public UserEntity create(@RequestBody UserEntity user){
        return service.addUser(user);
    }
}
