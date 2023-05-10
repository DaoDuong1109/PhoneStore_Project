package com.example.demo.controller;

import com.example.demo.entity.ProductColorEntity;
import com.example.demo.model.dto.productColor.ProductColorDTO;
import com.example.demo.model.dto.productColor.QuantityStatisticDTO;
import com.example.demo.service.ProductColorService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/productcolor")
@RestController
public class ProductColorController {

    @Autowired
    private ProductColorService service;
    @GetMapping("/findByProductId/{id}")
    public List<ProductColorDTO> findByProductId(@PathVariable int id){

        return service.productColorFindByProId(id);

    }
    @GetMapping("/findAll")
    public List<ProductColorEntity> findAll(){return service.getAll();}
    @PostMapping("/create")
    public List<ProductColorEntity> create(@RequestBody List<ProductColorEntity> list){
        return service.create(list);
    }
    @PutMapping("/updateByProId/{id}")
    public List<ProductColorEntity> update(@PathVariable int id, @RequestBody List<ProductColorEntity> list){
        return service.updateById(id,list);
    }

    @PutMapping("/updateAll")
    public List<ProductColorEntity> updateAll(@RequestBody List<ProductColorEntity> newList){
        return service.updateAll(newList);
    }

    @GetMapping("/getStatistic")
    public List<QuantityStatisticDTO> findStatistic(){return service.getStatistics();}
//    @GetMapping("/findByProductId")
//    public List<ProductColorDTO> findByProductName(@RequestParam(value = "name") String name){
//
//        return service.productByName(name);
//
//    }
}
