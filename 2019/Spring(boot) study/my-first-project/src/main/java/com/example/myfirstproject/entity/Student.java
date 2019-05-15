package com.example.myfirstproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data // getter, setter 등 자동생성
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hackbun")
    private String hackbun;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;
}
