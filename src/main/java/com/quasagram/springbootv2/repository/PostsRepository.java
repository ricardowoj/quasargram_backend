package com.quasagram.springbootv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quasagram.springbootv2.model.Post;

public interface PostsRepository extends JpaRepository<Post, Long> {
	
}
