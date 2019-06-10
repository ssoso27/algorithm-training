package com.example.smoothie.dto;

import lombok.Data;

@Data
public class SimpleCommentDTO {
    private Integer id;
    private Integer post_id;
    private String content;
}
