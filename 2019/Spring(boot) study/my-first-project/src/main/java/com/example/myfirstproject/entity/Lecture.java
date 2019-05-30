package com.example.myfirstproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="lectures")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="credit")
    private Integer credit;
}
