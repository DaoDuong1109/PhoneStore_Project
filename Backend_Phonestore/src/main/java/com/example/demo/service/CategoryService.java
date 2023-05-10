package com.example.demo.service;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService{
    @Autowired
    private CategoryRepository repository;

    @Autowired
    private ProductRepository productRepository;
    public List<CategoryEntity> getCategories(){
        return repository.findAll();
    }
    public CategoryEntity getCategoryById(int id){
        return repository.findById(id).orElse(null);
    }
    public CategoryEntity createCategory(CategoryEntity category){
        return repository.save(category);}
    public  CategoryEntity updateCategory(int id ,CategoryEntity category){
        CategoryEntity old=repository.findById(id).orElse(null);
        if(old!=null){
            old.setBrand(category.getBrand());
            old.setImage(category.getImage());
            return repository.save(old);
        }
        return null;
    }
    public String deleteCategory(int id){
        //check product.getCate va set ve null
//        List<ProductEntity> pro = productRepository.findByCateId(id);
//        if(pro.isEmpty()){
//            repository.deleteById(id);
//            return "success";
//        }
//        else {
//            for (ProductEntity p : pro) {
//                p.setCategoryId(0);
//                productRepository.save(p);
//            }
//            return "successful";
//        }

        try{
            repository.deleteById(id);
        }catch (Exception e){
            return e.getMessage();
        }
        return "Successful";
    }
}
