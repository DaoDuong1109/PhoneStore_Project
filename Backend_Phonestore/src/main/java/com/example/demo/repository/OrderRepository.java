package com.example.demo.repository;

import com.example.demo.entity.OrdersEntity;
import com.example.demo.model.dto.order.DetailOrderIdDTO;
import com.example.demo.model.dto.order.OrderByUserDTO;
import com.example.demo.model.dto.order.RevenueByYear;
import com.example.demo.model.dto.order.RevenueDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrdersEntity, Integer> {
    @Query("select new com.example.demo.model.dto.order.OrderByUserDTO(od.orderId, o.createdDate, " +
            "sum(od.amount*od.price), o.status) " +
            " from OrdersEntity o join OrderDetailEntity od on o.id=od.orderId " +
            " where o.userEntity.id=?1 " +
            " group by od.orderId" +
            " order by o.createdDate desc ")
    List<OrderByUserDTO> getByUser(int id);

    @Query("SELECT new com.example.demo.model.dto.order.RevenueDTO(month(o.createdDate), year(o.createdDate), sum(od.price*od.amount)) " +
            " from OrdersEntity o join OrderDetailEntity od on o.id=od.orderId " +
            " where o.status=1 and year(o.createdDate)=?1" +
            " group by month(o.createdDate)" +
            " order by month(o.createdDate) asc")
    List<RevenueDTO> findByYear(int year);

    @Query("select new com.example.demo.model.dto.order.RevenueByYear(sum(od.amount*od.price)) " +
            " from OrdersEntity o join OrderDetailEntity od on o.id=od.orderId " +
            " where o.status=1 and year(o.createdDate)=?1")
    RevenueByYear getAllYear(int year);
    @Query("select new com.example.demo.model.dto.order.DetailOrderIdDTO(od.orderId, od.productId, p.name, od.colorId, c.name, od.amount, od.price)" +
            " from OrdersEntity o join OrderDetailEntity od on o.id=od.orderId" +
            " join ProductEntity p on p.id=od.productId" +
            " join ColorEntity c on od.colorId=c.id" +
            " where od.orderId=?1")
    List<DetailOrderIdDTO> getDetailOrderId(int orderId);
}
