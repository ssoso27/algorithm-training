package com.example.smoothie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Column(name="created_at")
    protected LocalDateTime createdAt;

    @Column(name="updated_at")
    protected LocalDateTime updatedAt;
}
