package com.example.smoothie.repository;

import com.example.smoothie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO users (email, nickname, password, intro) VALUES (:email, :nickname, :password, :intro)", nativeQuery = true)
    void simpleSave(@Param("email") String email, @Param("nickname") String nickname, @Param("password") String password, @Param("intro") String intro);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users SET email = :email, nickname = :nickname, password = :password, intro = :intro WHERE id = :id", nativeQuery = true)
    void simpleUpdate(@Param("id") Long id, @Param("email") String email, @Param("nickname") String nickname, @Param("password") String password, @Param("intro") String intro);

}
