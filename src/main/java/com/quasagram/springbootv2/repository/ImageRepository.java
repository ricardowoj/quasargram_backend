package com.quasagram.springbootv2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quasagram.springbootv2.model.Image;

public interface ImageRepository extends JpaRepository<Image, String>{
	
}
	