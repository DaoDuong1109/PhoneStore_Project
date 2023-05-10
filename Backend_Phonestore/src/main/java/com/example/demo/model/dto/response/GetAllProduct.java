package com.example.demo.model.dto.response;

import com.example.demo.model.dto.product.ProductDTO;
import lombok.Data;

import java.util.List;

@Data
public class GetAllProduct {
    private List<ProductDTO> productDTOList;
    private int totalPage;
}
