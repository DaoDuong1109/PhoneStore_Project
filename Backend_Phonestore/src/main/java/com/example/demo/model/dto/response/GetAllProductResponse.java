package com.example.demo.model.dto.response;

import com.example.demo.entity.ProductEntity;
import lombok.Data;

import java.util.List;

@Data
public class GetAllProductResponse {
    private List<ProductEntity> productEntities;
    private int totalPage;
}
