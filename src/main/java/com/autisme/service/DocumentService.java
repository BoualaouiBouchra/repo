package com.autisme.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.autisme.modal.*;

public interface DocumentService {

	
	
Document addDocumentToFormateur(Document doc, long idformateur);
	
	//Document editDocument(Document Document, long id);
	
	Document findDocumentById(long id);
	
	void deleteDocument(long id);
	
	List<Document> findAllDocuments();
	List<Document> findAllPdf();
	
	List<Document> findDocumentsForFormateur(long idFormateur);
	

	Document getDocument(Long id);
	
	 public Document saveFile(MultipartFile file, String description_doc ,String titre_doc ,long  idformateur, String description_doc_arab ,String titre_doc_arab);
}
