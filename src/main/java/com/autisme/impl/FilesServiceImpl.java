package com.autisme.impl;


import java.util.List;
import java.io.IOException;
import java.net.MalformedURLException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.autisme.dao.*;
import com.autisme.modal.*;
import com.autisme.service.*;




import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;


@Transactional
@Component
public class FilesServiceImpl  implements FilesService{
	
	
	

	@Autowired 
	private EventDao eventDao;

	@Autowired 
	private FilesDao filesDao;


	@Override
	public Files addFilesToEvent(Files files, long idevent) {
		
		Event event = eventDao.findById(idevent).orElse(null);
		event.addFilesToEvent(files);
		return filesDao.save(files);
		
	}

	
	@Override
	public Files findFilesById(long id) {
		return filesDao.findById(id).orElse(null);
	}

	@Override
	public void deleteFiles(long id) {
		filesDao.deleteById(id);
		
	}

	@Override
	public List<Files> findFilessForEvent(long idEvent) {
		Event event = eventDao.findById(idEvent).orElse(null);
		return event.getFiles();
	}

	@Override
	public Files getFiles(Long id) {
		return filesDao.findById(id).orElse(null);
	}


	@Override
	public List<com.autisme.modal.Files> findAllFiless() {
		
		return filesDao.findAll();
	}


	@Override
	public List<Files> findAllPdf() {
	
		return filesDao.findByType("application/pdf");
	}


	@Override
	public Files saveFile(MultipartFile file) {
		
		  try {
			  Files doc = new Files(file.getOriginalFilename(),file.getContentType(),file.getContentType(),file.getBytes());
			  return filesDao.save(doc);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return null;
	}


	@Override
	public Files findOneFileForEvent(long idEvent) {
		Event event = eventDao.findById(idEvent).orElse(null);
		if(!event.getFiles().isEmpty())
		return event.getFiles().get(0);
		else
			return null;
	}

	
	

	}


