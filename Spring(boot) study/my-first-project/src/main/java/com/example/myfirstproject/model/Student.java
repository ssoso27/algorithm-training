package com.example.myfirstproject.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data // getter, setter 등 자동생성
@Entity(name = "Student") // Student 라는 도메인 생성
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String hackbun;
    private String birthday;
    private String name;
    private String gender;
}
