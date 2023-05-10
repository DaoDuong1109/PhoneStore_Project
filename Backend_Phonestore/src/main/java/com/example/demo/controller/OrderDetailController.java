package com.example.demo.controller;

import com.example.demo.entity.OrderDetailEntity;
import com.example.demo.model.dto.orderDetail.OrderConfirmDTO;
import com.example.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    private OrderDetailService service;
    @GetMapping("/findAll")
    public List<OrderDetailEntity> findAll(){
        return service.getAll();
    }
    @GetMapping("/findAllOrderConfirm")
    public List<OrderConfirmDTO> findAllOrderConfirm(){
        return service.getOrderConfirm();
    }
    @GetMapping("/findAllByOrderId/{id}")
    public List<OrderDetailEntity> findAllByOrderId(@PathVariable int id){
        return service.getOrderByOrderId(id);
    }
    @PostMapping("/createOrderDetail")
    public OrderDetailEntity create(@RequestBody OrderDetailEntity entity){
        return service.addOrderDetail(entity);
    }

}
