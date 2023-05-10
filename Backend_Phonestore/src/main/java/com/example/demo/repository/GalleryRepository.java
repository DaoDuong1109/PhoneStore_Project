package com.example.demo.repository;

import com.example.demo.entity.GaleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GalleryRepository extends JpaRepository<GaleryEntity,Integer> {
    @Query("select g from GaleryEntity g where g.productEntity.id=?1")
    List<GaleryEntity> findByProductId(int proid);
}
