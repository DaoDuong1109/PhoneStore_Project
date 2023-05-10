package com.example.demo.repository;

import com.example.demo.entity.ProductColorEntity;
import com.example.demo.entity.ProductColorEntityPK;
import com.example.demo.entity.ProductEntity;
import com.example.demo.model.dto.productColor.ProductColorDTO;
import com.example.demo.model.dto.productColor.QuantityStatisticDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface ProductColorRepository extends JpaRepository<ProductColorEntity, ProductColorEntityPK> {

    //    @Query("SELECT m FROM Product m WHERE m.name LIKE ?1%")
    @Query("SELECT pc FROM ProductColorEntity pc join ColorEntity c on pc.colorId=c.id where pc.productId=?1")
    List<ProductColorEntity> findByProductId(int id);

    @Query("SELECT new com.example.demo.model.dto.productColor.QuantityStatisticDTO( c.brand , sum(amount)) " +
            " from ProductColorEntity pc join ProductEntity p on pc.productId=p.id" +
            " join CategoryEntity c on p.categoryEntity.id=c.id " +
            " group by c.brand")
    List<QuantityStatisticDTO> getQuantityStatistic();

    @Query("select new com.example.demo.model.dto.productColor.ProductColorDTO(pc.productId, c.id, c.name,pc.amount ,pc.price) " +
            " from ProductColorEntity pc join ColorEntity c on pc.colorId=c.id" +
            " where pc.productId=?1")
    List<ProductColorDTO> getProductColorAdmin(int productId);

    //@Query("SELECT new com.example.demo.model.dto.orderDetail.OrderConfirmDTO(od.orderId, u.fullname, u.phone, " +
    //            "sum(od.amount*od.price), o.createdDate, o.status) " +
    //            " FROM OrdersEntity o join OrderDetailEntity od on o.id=od.orderId " +
    //            " join UserEntity  u on o.userEntity.id=u.id " +
    //            " group by od.orderId" +
    //            " order by od.orderId asc")
    //    List<OrderConfirmDTO> getOrderConfirm();
}