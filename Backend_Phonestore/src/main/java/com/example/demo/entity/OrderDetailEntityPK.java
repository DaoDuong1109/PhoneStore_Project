package com.example.demo.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailEntityPK implements Serializable {
    @Column(name = "product_ID", nullable = false)

    @Id
    private Integer productId;
    @Column(name = "order_ID", nullable = false)

    @Id
    private Integer orderId;
    @Column(name = "color_ID", nullable = false)
    @Basic
    @Id
    private Integer colorId;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetailEntityPK that = (OrderDetailEntityPK) o;
        return Objects.equals(productId, that.productId) && Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, orderId);
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }
}
