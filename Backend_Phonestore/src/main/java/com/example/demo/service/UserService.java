package com.example.demo.service;

import com.example.demo.entity.GaleryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<UserEntity> getUsers(){
        return repository.findAll();
    }
    public UserEntity getById(int id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    }
    public UserEntity addUser(UserEntity user){

        return repository.save(user);
    }
    public UserEntity updateUserByEmail(String email, UserEntity user){
         UserEntity old=repository.findByEmail(email);
        if(old!=null){
            old.setFullname(user.getFullname());
            old.setEmail(user.getEmail());
            old.setPhone(user.getPhone());
            old.setAddress(user.getAddress());
            old.setPassword(old.getPassword());
            old.setRoleEntity(old.getRoleEntity());
            return repository.save(old);
        }
        return null;
    }
    public UserEntity updateUserById(int id, UserEntity user){
        UserEntity old=repository.findById(id).orElse(null);
        if(old!=null){
            old.setFullname(user.getFullname());
            old.setEmail(user.getEmail());
            old.setPhone(user.getPhone());
            old.setAddress(user.getAddress());
            old.setPassword(user.getPassword());
            old.setRoleEntity(user.getRoleEntity());
            return repository.save(old);
        }
        return null;
    }
    public String delete(int id){
        UserEntity admin=repository.findById(id).orElse(null);
        if(admin!=null && !"admin".equals(admin.getFullname())){
            repository.deleteById(id);
            return "Successful";
        }
        return "Không được xóa admin";
    }
    public UserEntity GetUserByEmailPass(String email, String pass){
        UserEntity user=repository.findByEmailAndPass(email, pass).orElse(null);
        if(user!=null){
            return user;
        }else{
            return null;
        }
    }
}
