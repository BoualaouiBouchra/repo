package com.autisme.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.autisme.modal.Document;
import com.autisme.modal.Event;
import com.autisme.modal.Files;

import com.autisme.service.*;

@RestController
@RequestMapping(value = "/api/public")
@CrossOrigin(origins = "http://localhost:4200/")
public class DocumentController {
	
	
	@Autowired
	private DocumentService docService;
	
	
	
	@DeleteMapping("/deleteDoc/{id}")
	ResponseEntity<Document> deleteImg(@PathVariable long id) {
		docService.deleteDocument(id);
		 return new ResponseEntity<Document>(HttpStatus.OK); 
	
		
	}
	
	
	@GetMapping("/findDocumentsAll")
	List<Document> findAllFiless() {
		List<Document> ff=	docService.findAllDocuments();
	//	System.out.println(ff.get(0).getNom_doc());
		
		
		return docService.findAllDocuments();
	}
	
	
	
	 @GetMapping(value="/docDown/{id}",produces="application/json")
	  @ResponseBody
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("id") long id){
		Document doc = docService.getDocument(id);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getExt_doc()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getNom_doc()+"\"")
				.body(new ByteArrayResource(doc.getContent_doc()));
	}
	 
	 
	 
	 
	@PostMapping( value ="/addf",
			produces = MediaType.APPLICATION_JSON_VALUE,
		    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE}
)
	/* void add(@RequestPart("event") Event event, @RequestPart("file[]") MultipartFile file) {
		eventService.f(file,event);
		
	}*/
	
	 ResponseEntity<Document> add( @RequestPart("file[]") MultipartFile[] file ,@RequestPart("description_doc") String description_doc ,@RequestPart("titre_doc") String titre_doc ,@RequestPart("description_doc_arab") String description_doc_arab ,@RequestPart("titre_doc_arab") String titre_doc_arab,@RequestPart("formateur_id") long formateur_id) {

		

		
		for(int i=0;i<file.length;i++){
            System.out.println(file[i].getOriginalFilename());
            docService.saveFile(file[i],description_doc,titre_doc,formateur_id,description_doc_arab,titre_doc_arab);
             }
		 return new ResponseEntity<Document>(HttpStatus.OK); 
			
	}
	
	
	@GetMapping("/findDocumentsbyFormateur/{id}")
	List<Document> findFilesbyFormateur(@PathVariable long id) {
	
		return docService.findDocumentsForFormateur(id);
	}

}
