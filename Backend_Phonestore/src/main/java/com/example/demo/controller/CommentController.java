package com.example.demo.controller;

import com.example.demo.entity.CommentEntity;
import com.example.demo.model.dto.comment.CommentProductDTO;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/comment")
@RestController
public class CommentController {
    @Autowired
    private CommentService service;

    @GetMapping("/findByProId/{id}")
    public List<CommentProductDTO> findByProId(@PathVariable int id){return service.getByProId(id);}
    @GetMapping("/findAll")
    public List<CommentEntity> findAll(){return service.getAll();}
    @GetMapping("/findById/{id}")
    public CommentEntity findById(@PathVariable int id){return service.getById(id);}
    @PostMapping("/create")
    public CommentEntity createComment(@RequestBody CommentEntity comment){
        return service.addByUser(comment);
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteComment(@PathVariable int id){
        return service.deleleById(id);
    }
}
