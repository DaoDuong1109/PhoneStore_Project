package com.example.demo.repository;

import com.example.demo.entity.OrderDetailEntity;
import com.example.demo.entity.OrderDetailEntityPK;
import com.example.demo.model.dto.orderDetail.OrderConfirmDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, OrderDetailEntityPK> {

    @Query("SELECT new com.example.demo.model.dto.orderDetail.OrderConfirmDTO(od.orderId, u.fullname, u.phone, " +
            "sum(od.amount*od.price), o.createdDate, o.status) " +
            " FROM OrdersEntity o join OrderDetailEntity od on o.id=od.orderId " +
            " join UserEntity  u on o.userEntity.id=u.id " +
            " group by od.orderId" +
            " order by od.orderId asc")
    List<OrderConfirmDTO> getOrderConfirm();

    @Query("Select od " +
            " from OrderDetailEntity od join OrdersEntity o on od.orderId=o.id " +
            " where od.orderId=?1")
    List<OrderDetailEntity> getOrderByOrderId(int id);
}
