package com.example.demo.controller;

import com.example.demo.entity.SaleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@RequestMapping("/sale")
@RestController
public class SaleController {
    @Autowired
    private SaleService service;

    @GetMapping("/findAll")
    public List<SaleEntity> findAll(){

        return service.getAll();
    }
    @GetMapping("/saleById/{id}")
    public SaleEntity findById(@PathVariable int id){return service.getById(id);}


    @PostMapping("/create")
    public SaleEntity create(@RequestBody SaleEntity sale){
        return service.addSale(sale);
    }
    @PutMapping("/updateById/{id}")
    public SaleEntity updateById(@PathVariable int id, @RequestBody SaleEntity sale){
        return service.updateSaleById(id, sale);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return service.deleteSale(id);
    }
}
