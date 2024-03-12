package com.example.blog_app.dao;

import com.example.blog_app.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO extends JpaRepository<Post, Long> {

}
