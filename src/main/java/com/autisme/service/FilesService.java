package com.autisme.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.autisme.modal.*;

public interface FilesService {
	
Files addFilesToEvent(Files files, long idevent);
	
	//Files editFiles(Files files, long id);
	
	Files findFilesById(long id);
	
	void deleteFiles(long id);
	
	List<Files> findAllFiless();
	List<Files> findAllPdf();
	
	List<Files> findFilessForEvent(long idEvent);
	Files findOneFileForEvent(long idEvent);
	

	Files getFiles(Long id);
	
	 public Files saveFile(MultipartFile file);

}
