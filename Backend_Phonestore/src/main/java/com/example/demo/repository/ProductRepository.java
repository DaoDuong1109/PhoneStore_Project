package com.example.demo.repository;

import com.example.demo.entity.ProductEntity;
import com.example.demo.model.dto.product.DetailProductDTO;
import com.example.demo.model.dto.product.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.model.dto.product.ProductTrendingDTO;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
//    @Query("SELECT m FROM Product m WHERE m.name LIKE ?1%")
//    public List<ProductEntity> findByName(String name);

    //findAllPagination
    @Query("SELECT NEW com.example.demo.model.dto.product.ProductDTO(p.ID, p.name, p.image,c.id, c.name, pc.price, " +
            "p.categoryEntity,s.fromDate, s.toDate, s.discount, s.status)  " +
            "FROM ProductEntity p join ProductColorEntity pc on p.id=pc.productId " +
            "join SaleEntity s on p.saleEntity.id=s.id " +
            "join ColorEntity c on pc.colorId=c.id " +
            " where pc.amount>0 ")
    Page<ProductDTO> findWithPagination(Pageable pageable);
    //findAllWithSearchProductName
    @Query("SELECT NEW com.example.demo.model.dto.product.ProductDTO(p.ID, p.name, p.image,c.id, c.name, pc.price, " +
            "p.categoryEntity,s.fromDate, s.toDate, s.discount, s.status)  " +
            "FROM ProductEntity p join ProductColorEntity pc on p.id=pc.productId " +
            "join SaleEntity s on p.saleEntity.id=s.id " +
            "join ColorEntity c on pc.colorId=c.id " +
            " where pc.amount>0 and p.name like %?1%")
    Page<ProductDTO> findWithKeySearch(@Param(value = "keyword") String keyword, Pageable pageable);
    //findAllWithSearchCategoryID
    @Query("SELECT NEW com.example.demo.model.dto.product.ProductDTO(p.ID, p.name, p.image,c.id, c.name, pc.price, " +
            "p.categoryEntity,s.fromDate, s.toDate, s.discount, s.status)  " +
            "FROM ProductEntity p join ProductColorEntity pc on p.id=pc.productId " +
            "join SaleEntity s on p.saleEntity.id=s.id " +
            "join ColorEntity c on pc.colorId=c.id " +
            " where pc.amount>0 and p.categoryEntity.id=?1")
    Page<ProductDTO> findWithKeySearchCategory(@Param(value = "brand") String brand, Pageable pageable);
    //findAll
    @Query("SELECT NEW com.example.demo.model.dto.product.ProductDTO(p.ID, p.name, p.image,c.id, c.name, pc.price," +
            " p.categoryEntity, s.fromDate, s.toDate, s.discount, s.status)  " +
            "FROM ProductEntity p join ProductColorEntity pc on p.id=pc.productId " +
            "join SaleEntity s on p.saleEntity.id=s.id " +
            "join ColorEntity c on pc.colorId=c.id " +
            " where pc.amount>0 ")
    List<ProductDTO> findProducts();

    //find treding
    @Query("SELECT NEW com.example.demo.model.dto.product.ProductTrendingDTO(p.ID, p.name, p.image,c.id, c.name, pc.price," +
            " p.categoryEntity, s.fromDate, s.toDate, s.discount, s.status)  " +
            "FROM ProductEntity p join ProductColorEntity pc on p.id=pc.productId " +
            "join SaleEntity s on p.saleEntity.id=s.id " +
            "join ColorEntity c on pc.colorId=c.id " +
            " where pc.amount>0 and p.trending=1")
    List<ProductTrendingDTO> findByTrending();

    //find by category
    @Query("SELECT NEW com.example.demo.model.dto.product.ProductDTO( p.id , p.name, p.image, c.id ,c.name,pc.price," +
            " p.categoryEntity, s.fromDate, s.toDate, s.discount, s.status) " +
            " FROM ProductEntity p join ProductColorEntity pc on p.id=pc.productId" +
            " join ColorEntity c on pc.colorId=c.id " +
            " join SaleEntity s on p.saleEntity.id=s.id" +
            " where pc.amount>0 and p.categoryEntity.id=?1")
    List<ProductDTO> findByCategory(int categoryId);

    //find by product id and color id
    @Query("SELECT NEW com.example.demo.model.dto.product.DetailProductDTO(p.ID, p.name, p.screen, p.operatingSystem," +
            " p.rearCamera, p.frontCamera, p.cpu,\n" +
            " p.ram, p.insideMemory, p.memoryCard, p.battery, p.image, pc.price, pc.amount, pc.colorId, c.name," +
            " p.categoryEntity, s.fromDate, s.toDate, s.discount, s.status) " +
            " FROM ProductEntity p join ProductColorEntity pc on p.id=pc.productId " +
            " join ColorEntity c on pc.colorId=c.id" +
            " join SaleEntity s on p.saleEntity.id=s.id" +
            " where pc.productId=?1 and pc.colorId=?2")
    DetailProductDTO findByProColId(int productId, int colorId);

    //find by category id
    @Query("SELECT p FROM ProductEntity p WHERE categoryEntity.id=?1")
    List<ProductEntity> findByCateId(int category_id);
//    @Query("SELECT m FROM Product m WHERE m.name LIKE ?1%")
//    List<Product> searchByRatingStartsWith(String name);
}
