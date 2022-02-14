package com.example.blogmanagement.repository;

import com.example.blogmanagement.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    boolean existsByBlogIdAndStatusAndDateEquals(int blogId, String status, LocalDate date);

}
