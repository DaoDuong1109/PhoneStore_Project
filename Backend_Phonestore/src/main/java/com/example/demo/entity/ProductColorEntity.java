package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "product_color", schema = "phone_store", catalog = "")
@IdClass(ProductColorEntityPK.class)
public class ProductColorEntity {
//    @EmbeddedId
//    private ProductColorEntityPK id;

    @Id
    @Column(name = "product_ID", nullable = false)
    private Integer productId;

    @Id
    @Column(name = "color_ID", nullable = false)
    private Integer colorId;

    @Basic
    @Column(name = "price", nullable = true, precision = 0)
    private Double price;
    @Basic
    @Column(name = "amount", nullable = true)
    private Integer amount;


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

//    public ProductColorEntityPK getId() {
//        return id;
//    }
//
//    public void setId(ProductColorEntityPK id) {
//        this.id = id;
//    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductColorEntity that = (ProductColorEntity) o;
        return Objects.equals(productId, that.productId) && Objects.equals(colorId, that.colorId) && Objects.equals(price, that.price) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, colorId, price, amount);
    }
}
