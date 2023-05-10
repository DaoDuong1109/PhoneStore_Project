package com.example.demo.model.dto.product;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.entity.SaleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DetailProductDTO {
    private int id;
    private String productName;
    private String screen;
    private String system;
    private String rearCamera;
    private String frontCamera;
    private String cpu;
    private String ram;
    private String inside;
    private String outside;
    private String battery;
    private String image;
    private Double price;
    private Integer amount;
    private int colorId;
    private String colorName;
    private CategoryEntity category;
    Timestamp fromDate;
    Timestamp toDate;
    double discount;
    boolean saleStatus;
}
