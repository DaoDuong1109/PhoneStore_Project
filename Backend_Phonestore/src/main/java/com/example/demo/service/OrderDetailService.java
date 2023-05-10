package com.example.demo.service;

import com.example.demo.entity.OrderDetailEntity;
import com.example.demo.model.dto.orderDetail.OrderConfirmDTO;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    private OrderDetailRepository repository;
    public List<OrderDetailEntity> getAll(){
        return repository.findAll();
    }
    public OrderDetailEntity addOrderDetail(OrderDetailEntity entity){
        return repository.save(entity);
    }
    public List<OrderConfirmDTO> getOrderConfirm(){
        return repository.getOrderConfirm();
    }
    public List<OrderDetailEntity> getOrderByOrderId(int id){
        return repository.getOrderByOrderId(id);
    }
}
