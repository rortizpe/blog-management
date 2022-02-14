package com.example.blogmanagement.repository;

import com.example.blogmanagement.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

    int countByAuthorId(int authorId);
}
