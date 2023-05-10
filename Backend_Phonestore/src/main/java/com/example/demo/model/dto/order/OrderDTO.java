package com.example.demo.model.dto.order;

import com.example.demo.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    int id;
    String address;
    String phone;
    String email;
    Timestamp created_date;
    int status;
    UserEntity user;
}
