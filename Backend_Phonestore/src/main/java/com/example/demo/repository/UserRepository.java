package com.example.demo.repository;

import com.example.demo.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    @Query("SELECT u " +
            " FROM UserEntity u " +
            " WHERE u.email=?1")
    UserEntity findByEmail(String email);
    @Query("SELECT u " +
            " FROM UserEntity u " +
            " WHERE u.email=?1 and u.password=?2")
    Optional<UserEntity> findByEmailAndPass(String email, String pass);
}
