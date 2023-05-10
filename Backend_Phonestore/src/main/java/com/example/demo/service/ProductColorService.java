package com.example.demo.service;

import com.example.demo.entity.ColorEntity;
import com.example.demo.entity.ProductColorEntity;
import com.example.demo.model.dto.productColor.ProductColorDTO;
import com.example.demo.model.dto.productColor.QuantityStatisticDTO;
import com.example.demo.repository.ColorRepository;
import com.example.demo.repository.ProductColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductColorService {
    @Autowired
    private ProductColorRepository repository;
    @Autowired
    private ColorRepository colorRepository;
    public List<ProductColorDTO> productColorFindByProId(int id){
        return repository.getProductColorAdmin(id);
    }
    public List<ProductColorEntity> create(List<ProductColorEntity> newLists){
        //tim danh sach da ton tai trong database theo productid
        List<ProductColorEntity> listByProId=repository.findByProductId(newLists.get(0).getProductId());
        //gan cac sp khong có trong ds mới sang
        List<ProductColorEntity> listNewProductColor=null;

        if(!listByProId.isEmpty()) {
            for (ProductColorEntity item : listByProId) {
                listNewProductColor = newLists.stream().filter(p -> p.getColorId() != item.getColorId()).toList();
            }
            return repository.saveAll(listNewProductColor);
        }
        else{
            return repository.saveAll(newLists);
        }


    }

    public List<ProductColorEntity> updateById(int productId ,List<ProductColorEntity> newLists){
        //tim danh sach da ton tai trong database theo productid
        List<ProductColorEntity> oldLists=repository.findByProductId(productId);

        for (ProductColorEntity old: oldLists){

            ProductColorEntity newProductColor = newLists.stream()
                    .filter(p -> p.getColorId() == old.getColorId())//loc product color list theo color id ton tai trong list
                    .findFirst()
                    .orElse(null);

            if (newProductColor != null) {

                old.setAmount(newProductColor.getAmount());
                old.setPrice(newProductColor.getPrice());
                repository.save(old); // Cập nhật dữ liệu vào database
            }

        }

        //gan cac sp khong có trong ds mới sang
        List<ProductColorEntity> listNewProductColor=null;
        if(!oldLists.isEmpty()) {
            for (ProductColorEntity item : oldLists) {
                listNewProductColor = newLists.stream().filter(p -> p.getColorId() != item.getColorId()).toList();
            }
            return repository.saveAll(listNewProductColor);
        }
        else{
            repository.saveAll(newLists);
        }
         return oldLists;
    }
    public List<ProductColorEntity> updateAll(List<ProductColorEntity> newLists){
        return repository.saveAll(newLists);
    }
    public List<ProductColorEntity> getAll(){return repository.findAll();}
    public List<QuantityStatisticDTO> getStatistics(){return repository.getQuantityStatistic();}
}
