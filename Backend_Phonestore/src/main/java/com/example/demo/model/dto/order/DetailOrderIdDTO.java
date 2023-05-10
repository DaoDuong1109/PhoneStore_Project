package com.example.demo.model.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailOrderIdDTO {
    int orderId;
    int productId;
    String productName;
    int colorId;
    String colorName;
    int amount;
    Double price;
}
