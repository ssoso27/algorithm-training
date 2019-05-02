package com.example.myfirstproject.model;

import lombok.Data;

import javax.persistence.*;

@Data // getter, setter 등 자동생성
@Entity(name = "Student") // Student 라는 도메인 생성
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
