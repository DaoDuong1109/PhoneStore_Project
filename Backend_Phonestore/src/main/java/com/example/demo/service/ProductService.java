package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.model.dto.product.DetailProductDTO;
import com.example.demo.model.dto.product.ProductDTO;
import com.example.demo.model.dto.product.ProductTrendingDTO;
import com.example.demo.model.dto.response.GetAllProduct;
import com.example.demo.model.dto.response.GetAllProductResponse;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SaleRepository saleRepository;

//    public ResponseEntity<Page<ProductEntity>> getProducts(int page)
//    {
//        Pageable pageable= PageRequest.of(page,10, Sort.by("name"));
//        Page<ProductEntity> productPage=repository.findAllByOrderByLastNameAscFirstNameAsc(pageable);
//        return ResponseEntity.ok(productPage);
//
//    }
    public List<ProductEntity> getProducts(){
        return repository.findAll();
    }
    public GetAllProduct getAllProduct(Integer pageNumber, Integer pageSize, String keyword, String brand){
        if(pageNumber==null || pageNumber==0){
            pageNumber=1;
        }
        if(pageSize==0 || pageSize==null){
            pageSize=8;
        }
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize);
        Page<ProductDTO> productDTOPage;
        if(keyword!=null){
            productDTOPage=repository.findWithKeySearch(keyword,pageable);
        } else if (brand!=null) {
            productDTOPage=repository.findWithKeySearchCategory(brand,pageable);
        } else{
            productDTOPage=repository.findWithPagination(pageable);
        }
        GetAllProduct getAllProduct=new GetAllProduct();
        getAllProduct.setProductDTOList(productDTOPage.getContent());
        getAllProduct.setTotalPage(productDTOPage.getTotalPages());
        return getAllProduct;
    }
    public GetAllProduct getAllKeySearchProduct(Integer pageNumber, Integer pageSize, String keySearch){
        if(pageNumber==null || pageNumber==0){
            pageNumber=1;
        }
        if(pageSize==0 || pageSize==null){
            pageSize=8;
        }
        if(StringUtils.isEmpty(keySearch) ||keySearch.equals("") ){
            keySearch=null;
        }
        Pageable pageable=PageRequest.of(pageNumber-1,pageSize);
        Page<ProductDTO> productDTOPage=repository.findWithKeySearch(keySearch,pageable);
        GetAllProduct getAllProduct=new GetAllProduct();
        getAllProduct.setProductDTOList(productDTOPage.getContent());
        getAllProduct.setTotalPage(productDTOPage.getTotalPages());
        return getAllProduct;
    }
    public ProductEntity saveProduct(ProductEntity product){
        return repository.save(product);
    }
    public List<ProductEntity> saveAllProducts(List<ProductEntity> products){
        return repository.saveAll(products);
    }
    public ProductEntity getProductByID(int id){
        return repository.findById(id).orElse(null);
    }
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "product is removed: "+id;
    }
    public ProductEntity updateProduct(int id, ProductEntity product){
        CategoryEntity category=categoryRepository.findById(product.getCategoryEntity().getId()).orElse(null);
        SaleEntity sale=saleRepository.findById(product.getSaleEntity().getId()).orElse(null);
        if(category!=null){
            ProductEntity oldProduct=repository.findById(id).orElse(null);
            oldProduct.setName(product.getName());
            oldProduct.setImage(product.getImage());
            oldProduct.setScreen(product.getScreen());
            oldProduct.setOperatingSystem(product.getOperatingSystem());
            oldProduct.setFrontCamera(product.getFrontCamera());
            oldProduct.setRearCamera(product.getRearCamera());
            oldProduct.setCpu(product.getCpu());
            oldProduct.setRam(product.getRam());
            oldProduct.setInsideMemory(product.getInsideMemory());
            oldProduct.setMemoryCard(product.getMemoryCard());
            oldProduct.setBattery(product.getBattery());
            oldProduct.setTrending(product.getTrending());
            oldProduct.setStatus(product.getStatus());
            oldProduct.setCategoryEntity(category);
            oldProduct.setSaleEntity(sale);
            return repository.save(oldProduct);
        }
        return null;

    }
//    public List<ProductEntity> getProductByName(String name){
//        return repository.findByName(name);
//    }
    public DetailProductDTO getProductDetail(int productId, int colorId){
        return repository.findByProColId(productId, colorId);
    }
    public List<ProductDTO> getProductByCate(int categoryId){
        return repository.findByCategory(categoryId);
    }
    public List<ProductTrendingDTO> getProductTreding(){
        return repository.findByTrending();
//        List<ProductColorEntity> productColorEntityList=repo;
//        List<ProductColorDTO> productColorDTOS=new ArrayList<>();
//        for (ProductColorEntity item:productColorEntityList) {
//            ColorEntity color=colorRepository.findById(item.getColorId()).orElse(null);
//            ProductColorDTO productColorDTO= new ProductColorDTO().builder()
//                    .product_ID(item.getProductId())
//                    .color_ID(item.getColorId())
//                    .price(item.getPrice())
//                    .amount(item.getAmount())
//                    .colorName(color.getName())
//                    .build();
//            productColorDTOS.add(productColorDTO);
//        }
    }
    public List<ProductDTO> FindProducts(){return repository.findProducts();}
//    public Page<ProductDTO> getProductsWithPagination(int offset, int pageSize){
//        Page<ProductDTO> productsPage = repository.findWithPagination(PageRequest.of(offset, pageSize));
//        return productsPage;
//    }


}
