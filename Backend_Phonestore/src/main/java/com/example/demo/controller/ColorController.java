package com.example.demo.controller;

import com.example.demo.entity.ColorEntity;
import com.example.demo.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RequestMapping("/color")
@RestController
public class ColorController {
    @Autowired
    private ColorService service;
    @GetMapping("/colors")
    public List<ColorEntity> findAllColors(){return service.getColors();}

    @GetMapping("/colorById/{id}")
    public ColorEntity findColorById(@PathVariable int id){
        return service.getColorById(id);
    }
    @PostMapping("/createColor")
    public ColorEntity createColor(@RequestBody ColorEntity colorEntity){
        return service.createColor(colorEntity);
    }
    @PutMapping("/updateColorById/{id}")
    public ColorEntity updateColor(@PathVariable int id,@RequestBody ColorEntity colorEntity){
        return service.upadateColorById(id, colorEntity);
    }
    @DeleteMapping("/deleteColorById/{id}")
    public String deleteColor(@PathVariable int id){
        return service.deleteColorById(id);
    }
}
