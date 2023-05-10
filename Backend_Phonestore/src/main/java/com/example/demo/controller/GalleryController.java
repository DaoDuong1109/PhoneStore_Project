package com.example.demo.controller;

import com.example.demo.entity.GaleryEntity;
import com.example.demo.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/gallery")
@RestController
public class GalleryController {
    @Autowired
    private GalleryService service;
    @GetMapping("/findByProduct/{proId}")
    public List<GaleryEntity> findByProductId(@PathVariable int proId){
        return service.getByProductId(proId);
    }

    @GetMapping("/findAll")
    public List<GaleryEntity> findAll(){return service.getAllGallery();}
    @GetMapping("/findById/{id}")
    public GaleryEntity findById(@PathVariable int id){
        return service.getGalleryById(id);
    }
    @PostMapping("/create")
    public GaleryEntity createGallery(@RequestBody GaleryEntity galeryEntity){
        return service.addGallery(galeryEntity);
    }
    @PutMapping("/updateGallery/{id}")
    public GaleryEntity updateGallery(@PathVariable int id, @RequestBody GaleryEntity galeryEntity){
        return service.updateGalleryById(id, galeryEntity);
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable int id){
        return service.deleteGalleryById(id);
    }

}
