package com.example.smoothie.dto;

import lombok.Data;

@Data
public class SimpleCommentDTO {
    private Long id;
    private Long post_id;
    private String content;
}
