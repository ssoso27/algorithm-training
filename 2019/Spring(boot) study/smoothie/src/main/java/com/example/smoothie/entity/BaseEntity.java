package com.example.smoothie.entity;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class BaseEntity {

    @Column(name="createdAt")
    private LocalDateTime createdAt;

    @Column(name="updatedAt")
    private LocalDateTime updatedAt;
}
