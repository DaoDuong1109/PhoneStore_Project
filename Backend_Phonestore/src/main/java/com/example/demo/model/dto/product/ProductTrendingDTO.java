package com.example.demo.model.dto.product;

import com.example.demo.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductTrendingDTO {
    int id;
    String productName;
    String productImage;
    int colorId;
    String colorName;
    Double price;
    CategoryEntity category;
    Timestamp fromDate;
    Timestamp toDate;
    double discount;
    boolean saleStatus;
}
