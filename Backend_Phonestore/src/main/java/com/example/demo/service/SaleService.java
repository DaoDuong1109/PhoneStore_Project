package com.example.demo.service;

import com.example.demo.entity.SaleEntity;
import com.example.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository repository;


    public void updateTaskStatus() {
        List<SaleEntity> sales = repository.findAll();
        Timestamp now = new Timestamp(System.currentTimeMillis());
        for (SaleEntity sale : sales) {
            if (now.after(sale.getToDate()) && !sale.getStatus()) {
                sale.setStatus(true);
                repository.save(sale);
            }
        }
    }

    public List<SaleEntity> getAll(){

        updateTaskStatus();

        return repository.findAll();
    }
    public SaleEntity getById(int id){
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Sale not found"));
    }
    public SaleEntity addSale(SaleEntity saleEntity){
        return repository.save(saleEntity);
    }
    public SaleEntity updateSaleById(int id, SaleEntity saleEntity){
        SaleEntity old=repository.findById(id).orElse(null);
        if(old!=null){
            old.setFromDate(saleEntity.getFromDate());
            old.setToDate(saleEntity.getToDate());
            old.setStatus(saleEntity.getStatus());
            old.setDiscount(saleEntity.getDiscount());
            return repository.save(old);
        }
        return null;
    }
    public String deleteSale(int id){
        repository.deleteById(id);
        return "Successful";
    }
}
