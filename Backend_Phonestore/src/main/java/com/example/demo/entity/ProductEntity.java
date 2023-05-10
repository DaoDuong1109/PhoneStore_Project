package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "phone_store", catalog = "")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 50)
    private String name;
    @Basic
    @Column(name = "image", nullable = true, length = 100)
    private String image;
    @Basic
    @Column(name = "screen", nullable = false, length = 150)
    private String screen;
    @Basic
    @Column(name = "operating_system", nullable = false, length = 150)
    private String operatingSystem;
    @Basic
    @Column(name = "front_camera", nullable = false, length = 150)
    private String frontCamera;
    @Basic
    @Column(name = "rear_camera", nullable = false, length = 150)
    private String rearCamera;
    @Basic
    @Column(name = "CPU", nullable = false, length = 150)
    private String cpu;
    @Basic
    @Column(name = "RAM", nullable = false, length = 150)
    private String ram;
    @Basic
    @Column(name = "inside_memory", nullable = false, length = 150)
    private String insideMemory;
    @Basic
    @Column(name = "memory_card", nullable = false, length = 150)
    private String memoryCard;
    @Basic
    @Column(name = "battery", nullable = false, length = 150)
    private String battery;
    @Basic
    @Column(name = "trending", nullable = true)
    private Boolean trending;
    @Basic
    @Column(name = "status", nullable = false)
    private Boolean status;
    @Basic
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;
    @Basic
    @ManyToOne
    @JoinColumn(name = "sale_ID")
    private SaleEntity saleEntity;

//    @OneToMany(mappedBy = "product")
//    private List<ProductColorEntity> productColorEntities;

//    public List<ProductColorEntity> getProductColorEntities() {
//        return productColorEntities;
//    }
//
//    public void setProductColorEntities(List<ProductColorEntity> productColorEntities) {
//        this.productColorEntities = productColorEntities;
//    }
//    @Basic
//    @Column(name = "category_id", nullable = false)
//    private Integer categoryId;
//    @Basic
//    @Column(name = "sale_ID", nullable = false)
//    private Integer saleId;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getFrontCamera() {
        return frontCamera;
    }

    public void setFrontCamera(String frontCamera) {
        this.frontCamera = frontCamera;
    }

    public String getRearCamera() {
        return rearCamera;
    }

    public void setRearCamera(String rearCamera) {
        this.rearCamera = rearCamera;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getInsideMemory() {
        return insideMemory;
    }

    public void setInsideMemory(String insideMemory) {
        this.insideMemory = insideMemory;
    }

    public String getMemoryCard() {
        return memoryCard;
    }

    public void setMemoryCard(String memoryCard) {
        this.memoryCard = memoryCard;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public Boolean getTrending() {
        return trending;
    }

    public void setTrending(Boolean trending) {
        this.trending = trending;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public SaleEntity getSaleEntity() {
        return saleEntity;
    }

    public void setSaleEntity(SaleEntity saleEntity) {
        this.saleEntity = saleEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity product = (ProductEntity) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(image, product.image) && Objects.equals(screen, product.screen) && Objects.equals(operatingSystem, product.operatingSystem) && Objects.equals(frontCamera, product.frontCamera) && Objects.equals(rearCamera, product.rearCamera) && Objects.equals(cpu, product.cpu) && Objects.equals(ram, product.ram) && Objects.equals(insideMemory, product.insideMemory) && Objects.equals(memoryCard, product.memoryCard) && Objects.equals(battery, product.battery) && Objects.equals(trending, product.trending) && Objects.equals(status, product.status) && Objects.equals(categoryEntity, product.categoryEntity) && Objects.equals(saleEntity, product.saleEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, screen, operatingSystem, frontCamera, rearCamera, cpu, ram, insideMemory, memoryCard, battery, trending, status, categoryEntity, saleEntity);
    }

//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public Integer getSaleId() {
//        return saleId;
//    }
//
//    public void setSaleId(Integer saleId) {
//        this.saleId = saleId;
//    }
}
