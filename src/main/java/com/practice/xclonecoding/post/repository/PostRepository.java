package com.practice.xclonecoding.post.repository;

import com.practice.xclonecoding.account.domain.Account;
import com.practice.xclonecoding.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByCreatedAtDesc();

    List<Post> findByWriterOrderByCreatedAtDesc(Account writer);
}
