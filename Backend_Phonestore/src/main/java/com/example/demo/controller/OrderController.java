package com.example.demo.controller;

import com.example.demo.entity.OrdersEntity;
import com.example.demo.model.dto.order.DetailOrderIdDTO;
import com.example.demo.model.dto.order.OrderByUserDTO;
import com.example.demo.model.dto.order.RevenueByYear;
import com.example.demo.model.dto.order.RevenueDTO;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @GetMapping("/findAll")
    public List<OrdersEntity> findAll(){return service.getOrders();}
    @GetMapping("/findOrderById/{id}")
    public OrdersEntity findById(@PathVariable int id){
        return service.getOrderById(id);
    }
    @PostMapping("/createOrder")
    public OrdersEntity create(@RequestBody OrdersEntity order){
        return service.addOrder(order);
    }
    @GetMapping("/findByUser/{id}")
    public List<OrderByUserDTO> findByUser(@PathVariable int id){
        return service.findByUser(id);
    }
    @GetMapping("/revenue/{year}")
    public List<RevenueDTO> finByYear(@PathVariable int year){
        return service.getRevenue(year);
    }
    @GetMapping("/revenueAll/{year}")
    public RevenueByYear findAllYear(@PathVariable int year){
        return service.getRevenueAllYear(year);
    }
    @GetMapping("/getDetailOrderId/{id}")
    public List<DetailOrderIdDTO> findDetailOrderId(@PathVariable int id){
        return service.getDetailOrderId(id);
    }
    @PutMapping("/updateStatusById/{id}")
    public OrdersEntity updateStatusById(@PathVariable int id, @RequestBody OrdersEntity entity){
        return service.putOrderById(id, entity);
    }

}
