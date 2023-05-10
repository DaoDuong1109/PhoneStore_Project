package com.example.demo.service;

import com.example.demo.entity.GaleryEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.GalleryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService {
    @Autowired
    private GalleryRepository repository;
    @Autowired
    private ProductRepository productRepository;

    public List<GaleryEntity> getByProductId(int productId){
        return repository.findByProductId(productId);
    }
    public List<GaleryEntity> getAllGallery(){return repository.findAll();}
    public GaleryEntity getGalleryById(int id){return repository.findById(id).orElse(null);}
    public GaleryEntity addGallery(GaleryEntity galeryEntity){return repository.save(galeryEntity);}
    public GaleryEntity updateGalleryById(int id, GaleryEntity galeryEntity){
        ProductEntity product=productRepository.findById(galeryEntity.getProductEntity().getId()).orElse(null);
        if(product!=null){
            GaleryEntity old=repository.findById(id).orElse(null);
            old.setImage(galeryEntity.getImage());
            old.setProductEntity(product);
            return repository.save(old);
        }
        return null;
    }
    public String deleteGalleryById(int id){
        repository.deleteById(id);
        return "Successful";
    }
}
