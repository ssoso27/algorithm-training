package com.example.smoothie.repository;

import com.example.smoothie.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO comments (post_id, content) VALUES (:postId, :content)", nativeQuery = true)
    void simpleSave(@Param("postId") Integer postId, @Param("content") String content);

    @Modifying
    @Transactional
    @Query(value = "UPDATE comments SET content = :content WHERE id = :id", nativeQuery = true)
    void simpleUpdate(@Param("id") Integer id, @Param("content") String content);
}
