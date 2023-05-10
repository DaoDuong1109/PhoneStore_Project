package com.example.demo.service;

import com.example.demo.entity.OrdersEntity;
import com.example.demo.model.dto.order.DetailOrderIdDTO;
import com.example.demo.model.dto.order.OrderByUserDTO;
import com.example.demo.model.dto.order.RevenueByYear;
import com.example.demo.model.dto.order.RevenueDTO;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    public List<OrdersEntity> getOrders(){
        return repository.findAll();
    }
    public OrdersEntity getOrderById(int id){return repository.findById(id).orElse(null);}
    public OrdersEntity addOrder(OrdersEntity order){
        return repository.save(order);
    }

    public List<OrderByUserDTO> findByUser(int userId){
        return repository.getByUser(userId);
    }
    public OrdersEntity putOrderById(int id, OrdersEntity entity){
        OrdersEntity old=repository.findById(id).orElse(null);
        if(old!=null){
            old.setStatus(entity.getStatus());
            return repository.save(old);
        }
        return null;
    }
    public List<DetailOrderIdDTO> getDetailOrderId(int id){
        return repository.getDetailOrderId(id);
    }
    public List<RevenueDTO> getRevenue(int year){
        return repository.findByYear(year);
    }
    public RevenueByYear getRevenueAllYear(int year){
        return repository.getAllYear(year);
    }
}
