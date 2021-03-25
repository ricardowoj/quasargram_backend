package com.quasagram.springbootv2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quasagram.springbootv2.model.Post;
import com.quasagram.springbootv2.repository.PostsRepository;

@RestController
public class PostsController {
	
	@Autowired
	private PostsRepository postsRepository;
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/posts")
	public List<Post> all() {
		return postsRepository.findAll();
	}
	
	@PostMapping(value="/posts")
	Post newPost(@RequestBody Post post) {
		return postsRepository.save(post);
	}
	
}
