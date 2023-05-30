package com.shaan31.fmi.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shaan31.fmi.entities.FileData;
import com.shaan31.fmi.repositories.FileDataRepository;

@RestController
@RequestMapping("/files")
public class FileController {
	
	@Autowired
	FileDataRepository fileDataRepository;
	
	@GetMapping("/download/{id}")
	public ResponseEntity<FileData> downloadFile(@PathVariable("id") Long id){
		return new ResponseEntity<>(
			fileDataRepository
				.findById(id)
				.orElse(new FileData()), 
			HttpStatus.OK
		);
	}
	
	@GetMapping("/fetchDistinctFileNames")
	public ResponseEntity<List<String>> fetchDistinctFileNames(){
		return new ResponseEntity<>(
				fileDataRepository.findAll().stream().map(FileData::getFileName).toList(), 
				HttpStatus.OK);
	}
	
	@PostMapping("/upload")
	public ResponseEntity<FileData> uploadFile(@RequestBody FileData fileData, @RequestHeader("username") String username){
		fileData.setUploadedOn(Date.valueOf(LocalDate.now()));
		fileData.setUploadedBy(username);
		return new ResponseEntity<>(
			fileDataRepository.save(fileData),
			HttpStatus.OK
		);
	}
}
