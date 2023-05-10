package com.example.demo.model.dto.orderDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderConfirmDTO {
    int orderId;
    String fullname;
    String phone;
    Double totalPayment;
    Timestamp createdDate;
    Integer status;
}
