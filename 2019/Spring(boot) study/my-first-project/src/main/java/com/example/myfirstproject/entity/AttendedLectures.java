package com.example.myfirstproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="attended_lectures")
public class AttendedLectures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="student_id")
    private Integer studentId;

    @Column(name="lecture_id")
    private Integer lectureId;
}
