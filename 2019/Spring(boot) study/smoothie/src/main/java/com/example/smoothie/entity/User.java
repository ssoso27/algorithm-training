package com.example.smoothie.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="nickname")
    private String nickname;

    @JsonIgnore
    @Column(name="password")
    private String password;

    @Column(name="intro")
    private String intro;

    @JsonBackReference
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Comment> comments;

    @JsonBackReference
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Post> posts;
}
