package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "galery", schema = "phone_store", catalog = "")
public class GaleryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private Integer id;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @ManyToOne
    @JoinColumn(name = "product_ID")
    private ProductEntity productEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GaleryEntity that = (GaleryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(image, that.image) && Objects.equals(productEntity, that.productEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, productEntity);
    }
}
