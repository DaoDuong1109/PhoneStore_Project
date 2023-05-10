package com.example.demo.controller;

import com.example.demo.entity.SlideEntity;
import com.example.demo.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slide")
public class SlideController {
    @Autowired
    private SlideService service;

    @GetMapping("/slides")
    public List<SlideEntity> findAllSlides(){
        return service.getSlides();
    }
    @GetMapping("/slideById/{id}")
    public SlideEntity findSlideById(@PathVariable int id){
        return service.getSlideById(id);
    }
    @PostMapping("/createSlide")
    public SlideEntity createSlide(@RequestBody SlideEntity slide){
        return service.createSlide(slide);
    }
    @PutMapping("/updateSlideById/{id}")
    public SlideEntity updateSlide(@PathVariable int id, @RequestBody SlideEntity slide){
        return service.updateSlide(id, slide);
    }
    @DeleteMapping("/deleteSlideById/{id}")
    public String deleteSlideById(@PathVariable int id){
        return service.deleteSlide(id);
    }

}
