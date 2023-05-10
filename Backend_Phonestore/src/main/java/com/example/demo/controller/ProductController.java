package com.example.demo.controller;

import com.example.demo.entity.ProductEntity;
import com.example.demo.model.dto.product.DetailProductDTO;
import com.example.demo.model.dto.product.ProductDTO;
import com.example.demo.model.dto.product.ProductTrendingDTO;
import com.example.demo.model.dto.productColor.ProductColorDTO;
import com.example.demo.model.dto.response.APIResponse;
import com.example.demo.model.dto.response.GetAllProduct;
import com.example.demo.model.dto.response.GetAllProductResponse;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/product")
@RestController

public class ProductController {
    @Autowired
    private ProductService service;

//    @GetMapping("/products")
//    public List<ProductEntity> findAllProducts(){
//        return service.getProducts();
//    }

    @GetMapping("/products")
    public List<ProductEntity> getproduct(){
        return service.getProducts();
    }

    @PostMapping("/addProduct")
    public ProductEntity addProduct(@RequestBody ProductEntity product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<ProductEntity> addProducts(@RequestBody List<ProductEntity> products){
        return service.saveAllProducts(products);
    }
    @GetMapping("/productById/{id}")
    public ProductEntity findProductById(@PathVariable int id){
        return service.getProductByID(id);
    }
    @GetMapping("/productByName")
    public List<ProductEntity> findProductByName(@RequestParam("keyword") String keyword){
//        return service.getProductByName(keyword);
        return null;
    }
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProductById(@PathVariable int id){
        return service.deleteProduct(id);
    }
    @PutMapping("/updateProduct/{id}")
    public ProductEntity updateProduct(@PathVariable int id,@RequestBody ProductEntity product){
        return service.updateProduct(id,product);
    }
    @GetMapping("/findByCate/{proId}")
    List<ProductDTO> findByCate(@PathVariable int proId){
        return service.getProductByCate(proId);
    }
    @GetMapping("/findTreding")
    List<ProductTrendingDTO> findTrending(){
        return service.getProductTreding();
    }

    @GetMapping("/findDetailProduct")
    public DetailProductDTO findDetail(@RequestParam int id, @RequestParam int color){
        return service.getProductDetail(id, color);
    }
    @GetMapping("/pagination")
    public GetAllProduct findAllPagination(@RequestParam("keyword") Optional<String> keyword,@RequestParam("brand") Optional<String> brand ,Optional<Integer> offset, Optional<Integer> pageSize){
        return service.getAllProduct(offset.orElse(0),pageSize.orElse(0),keyword.orElse(null), brand.orElse(null));
    }
//    @GetMapping("/keysearch")
//    public GetAllProduct findAllKeySearch(@RequestParam Optional<String> search,Optional<Integer> offset, Optional<Integer> pageSize){
//        return service.getAllKeySearchProduct(offset.orElse(0), pageSize.orElse(0), search.orElse(null));
//    }
}
