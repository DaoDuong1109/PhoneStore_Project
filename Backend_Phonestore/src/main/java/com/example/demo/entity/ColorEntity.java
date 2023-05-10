package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "color", schema = "phone_store", catalog = "")
public class ColorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
//    @OneToMany(mappedBy = "color")
//    private List<ProductColorEntity> productColorEntities;

//    public List<ProductColorEntity> getProductColorEntities() {
//        return productColorEntities;
//    }
//
//    public void setProductColorEntities(List<ProductColorEntity> productColorEntities) {
//        this.productColorEntities = productColorEntities;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColorEntity that = (ColorEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
