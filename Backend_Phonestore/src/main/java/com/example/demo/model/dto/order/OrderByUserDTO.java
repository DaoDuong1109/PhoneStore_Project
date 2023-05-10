package com.example.demo.model.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderByUserDTO {
    int orderId;
    Timestamp createdDate;
    Double total;
    Integer status;
}
