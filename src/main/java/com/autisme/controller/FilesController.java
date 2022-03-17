package com.autisme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autisme.service.FilesService;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.autisme.modal.*;

@RestController
@RequestMapping(value = "/api/public")
@CrossOrigin(origins = "http://localhost:4200/")
public class FilesController {

	
	@Autowired
	private FilesService filesService;
	
	 @GetMapping(value="/files/{id}",produces="application/json")
	  @ResponseBody
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("id") long id){
		Files doc = filesService.getFiles(id);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getExt()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getNom()+"\"")
				.body(new ByteArrayResource(doc.getContent()));
	}
}
