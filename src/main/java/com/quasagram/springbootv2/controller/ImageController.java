package com.quasagram.springbootv2.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.quasagram.springbootv2.message.ResponseFile;
import com.quasagram.springbootv2.message.ResponseMessage;
import com.quasagram.springbootv2.service.ImageStorageService;

@Controller
public class ImageController {
	
	@Autowired
	private ImageStorageService imageService;
	
	@PostMapping(value="/images")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			imageService.store(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@GetMapping("/images")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		List<ResponseFile> files = imageService.getAllFiles().map(image -> {
			String fileDownloadUri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/files/")
					.path(image.getId())
					.toUriString();
			
			return new ResponseFile(
					image.getName(),
					fileDownloadUri,
					image.getType(),
					image.getData().length);
		}).collect(Collectors.toList());
		
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}
}
