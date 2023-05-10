package com.example.demo.service;

import com.example.demo.entity.ColorEntity;
import com.example.demo.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorService {
    @Autowired
    private ColorRepository repository;
    public List<ColorEntity> getColors(){
        return repository.findAll();
    }
    public ColorEntity getColorById(int id){
        return repository.findById(id).orElse(null);
    }
    public ColorEntity createColor(ColorEntity colorEntity){
        return repository.save(colorEntity);
    }
    public ColorEntity upadateColorById(int id, ColorEntity colorEntity){
        ColorEntity old=repository.findById(id).orElse(null);
        if(old!=null){
            old.setName(colorEntity.getName());
            return repository.save(old);
        }
        return null;
    }
    public String deleteColorById(int id){
        try{
            repository.deleteById(id);
        }catch (Exception e){
            return e.getMessage();
        }
        return "Successful";
    }
}
