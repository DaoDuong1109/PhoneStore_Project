package com.example.demo.service;

import com.example.demo.entity.SlideEntity;
import com.example.demo.repository.SlideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SlideService {
    @Autowired
    private SlideRepository repository;
    public List<SlideEntity> getSlides(){
        return repository.findAll();
    }
    public SlideEntity getSlideById(int id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Slide not found"));
//        return repository.findById(id).orElse(null);
    }
    public SlideEntity createSlide(SlideEntity slide){
        return repository.save(slide);
    }
    public SlideEntity updateSlide(int id,SlideEntity slide){
        SlideEntity oldSlide=repository.findById(id).orElse(null);
        if(oldSlide!=null){
            oldSlide.setName(slide.getName());
            oldSlide.setImage(slide.getImage());
            oldSlide.setStatus(slide.getStatus());
            return repository.save(oldSlide);
        }
        return null;
    }
    public String deleteSlide(int id){
        try{
            repository.deleteById(id);
        }catch (Exception e){
            return e.getMessage();
        }
        return "Successful";
    }
}
