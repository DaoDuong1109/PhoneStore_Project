package com.example.demo.model.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentProductDTO {
    int userID;
    String fullname;
    int commentId;
    String content;
}
