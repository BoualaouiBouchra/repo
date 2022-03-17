package com.autisme.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.autisme.dao.*;

import com.autisme.modal.*;
import com.autisme.service.*;




@Transactional
@Component

public class DocumentImpl  implements DocumentService{

	
	
	@Autowired 
	private UserDao formateurDao;

	@Autowired 
	private DocumentDao docDao; 
	
	@Override
	public Document addDocumentToFormateur(Document doc, long idformateur) {
		User formateur = formateurDao.findById(idformateur).orElse(null);
		formateur.addDocToFormateur(doc);
		
		return docDao.save(doc);	}

	@Override
	public Document findDocumentById(long id) {
		 return docDao.findById(id).orElse(null);
	}

	@Override
	public void deleteDocument(long id) {
		docDao.deleteById(id);
		
	}

	@Override
	public List<Document> findAllDocuments() {
		// TODO Auto-generated method stub
		return docDao.findAll();
	}

	@Override
	public List<Document> findAllPdf() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Document> findDocumentsForFormateur(long idFormateur) {
		User f = formateurDao.findById(idFormateur).orElse(null);
		return f.getDocs();
	}

	@Override
	public Document getDocument(Long id) {
		// TODO Auto-generated method stub
		return docDao.findById(id).orElse(null);
	}

	@Override
	public Document saveFile(MultipartFile file ,String description_doc,String titre_doc ,long idformateur  ,String description_doc_arab,String titre_doc_arab) {
		 try {
			 User formateur= formateurDao.findById(idformateur).orElse(null);
			 
			
			
			 Document doc = new Document(file.getOriginalFilename(),description_doc, description_doc_arab, titre_doc,
					 titre_doc_arab,file.getContentType(),file.getBytes(),formateur);
			
		
			
			return docDao.save(doc);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return null;
	}

}
