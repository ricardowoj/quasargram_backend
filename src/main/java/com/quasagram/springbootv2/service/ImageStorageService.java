package com.quasagram.springbootv2.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.quasagram.springbootv2.model.Image;
import com.quasagram.springbootv2.repository.ImageRepository;

@Service
public class ImageStorageService {
	
	@Autowired
	private ImageRepository imageRepository;
	
	public Image store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Image image = new Image(fileName, file.getContentType(), file.getBytes());
		
		return imageRepository.save(image);
	}
	
	public Image getFile(String id) {
		return imageRepository.findById(id).get();
	}
	
	public Stream<Image> getAllFiles() {
		return imageRepository.findAll().stream();
	}
}
