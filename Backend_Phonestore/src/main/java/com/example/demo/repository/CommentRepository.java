package com.example.demo.repository;

import com.example.demo.entity.CommentEntity;
import com.example.demo.model.dto.comment.CommentProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
    @Query("SELECT NEW com.example.demo.model.dto.comment.CommentProductDTO( u.id ,u.fullname, c.id, c.detail) " +
            "FROM CommentEntity c join ProductEntity p on p.id=c.productId " +
            " join UserEntity u on c.userEntity.id=u.id " +
            " where p.id=?1")
    List<CommentProductDTO> findByProductId(int proId);
}
