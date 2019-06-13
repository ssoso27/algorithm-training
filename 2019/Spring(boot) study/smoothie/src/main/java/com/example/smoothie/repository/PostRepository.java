package com.example.smoothie.repository;

import com.example.smoothie.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO posts (title, user_id, content) VALUES (:title, :userid, :content)", nativeQuery = true)
    void simpleSave(@Param("title") String title, @Param("userid") Long userId, @Param("content") String content);

    @Modifying
    @Transactional
    @Query(value = "UPDATE posts SET title = :title, content = :content WHERE id = :id", nativeQuery = true)
    void simpleUpdate(@Param("id") Long id, @Param("title") String title, @Param("content") String content);
}
