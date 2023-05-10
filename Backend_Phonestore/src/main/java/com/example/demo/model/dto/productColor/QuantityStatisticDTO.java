package com.example.demo.model.dto.productColor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuantityStatisticDTO {
    String name;
    Long amount;
}
