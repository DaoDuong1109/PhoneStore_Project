package com.example.demo.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class ProductColorEntityPK implements Serializable {

    @Column(name = "product_ID", nullable = false)
    @Id

    private Integer productId;
    @Column(name = "color_ID", nullable = false)
    @Id

    private Integer colorId;


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductColorEntityPK that = (ProductColorEntityPK) o;
        return Objects.equals(productId, that.productId) && Objects.equals(colorId, that.colorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, colorId);
    }
}
