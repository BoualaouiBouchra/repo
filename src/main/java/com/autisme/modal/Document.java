package com.autisme.modal;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "documents")
public class Document {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_doc;

	 private String nom_doc;

	 private String description_doc;

	 private String description_doc_arab;
	 
	 private String titre_doc;
	 private String titre_doc__arab;


	private String ext_doc;
	  @Lob
	  private byte[] content_doc;
	  
	  
	  
	  @JsonBackReference(value = "event")
			@ManyToOne( cascade = CascadeType.ALL)
		    private User formateur;
	  
	  
	  
	  
		public Document(Long id_doc, String nom_doc, String description_doc, String description_doc_arab, String titre_doc,
			String titre_doc__arab, String ext_doc, byte[] content_doc, User formateur) {
		super();
		this.id_doc = id_doc;
		this.nom_doc = nom_doc;
		this.description_doc = description_doc;
		this.description_doc_arab = description_doc_arab;
		this.titre_doc = titre_doc;
		this.titre_doc__arab = titre_doc__arab;
		this.ext_doc = ext_doc;
		this.content_doc = content_doc;
		this.formateur = formateur;
	}
		public Document(String nom_doc, String description_doc, String description_doc_arab, String titre_doc,
			String titre_doc__arab, String ext_doc, byte[] content_doc, User formateur) {
		super();
		this.nom_doc = nom_doc;
		this.description_doc = description_doc;
		this.description_doc_arab = description_doc_arab;
		this.titre_doc = titre_doc;
		this.titre_doc__arab = titre_doc__arab;
		this.ext_doc = ext_doc;
		this.content_doc = content_doc;
		this.formateur = formateur;
	}
		public String getDescription_doc_arab() {
			return description_doc_arab;
		}
		public void setDescription_doc_arab(String description_doc_arab) {
			this.description_doc_arab = description_doc_arab;
		}
		public String getTitre_doc__arab() {
			return titre_doc__arab;
		}
		public void setTitre_doc__arab(String titre_doc__arab) {
			this.titre_doc__arab = titre_doc__arab;
		}
	  
		 public Document(String nom_doc, String description_doc, String titre_doc, String ext_doc, byte[] content_doc,
			User formateur) {
		super();
		this.nom_doc = nom_doc;
		this.description_doc = description_doc;
		this.titre_doc = titre_doc;
		this.ext_doc = ext_doc;
		this.content_doc = content_doc;
		this.formateur = formateur;
	}
		public String getTitre_doc() {
				return titre_doc;
			}
			public void setTitre_doc(String titre_doc) {
				this.titre_doc = titre_doc;
			}
	  
	public Document(String nom_doc, String description_doc, String ext_doc, byte[] content_doc, User formateur) {
		super();
		this.nom_doc = nom_doc;
		this.description_doc = description_doc;
		this.ext_doc = ext_doc;
		this.content_doc = content_doc;
		this.formateur = formateur;
	}
	public Document(String nom_doc, String description_doc, String ext_doc, byte[] content_doc) {
		super();
		this.nom_doc = nom_doc;
		this.description_doc = description_doc;
		this.ext_doc = ext_doc;
		this.content_doc = content_doc;
	}
	public Document() {
		
	}
	public Document(Long id_doc, String nom_doc, String description_doc, String ext_doc, byte[] content_doc) {
		super();
		this.id_doc = id_doc;
		this.nom_doc = nom_doc;
		this.description_doc = description_doc;
		this.ext_doc = ext_doc;
		this.content_doc = content_doc;
	}
	public Long getId_doc() {
		return id_doc;
	}
	public void setId_doc(Long id_doc) {
		this.id_doc = id_doc;
	}
	public String getNom_doc() {
		return nom_doc;
	}
	public void setNom_doc(String nom_doc) {
		this.nom_doc = nom_doc;
	}
	public String getDescription_doc() {
		return description_doc;
	}
	public void setDescription_doc(String description_doc) {
		this.description_doc = description_doc;
	}
	public String getExt_doc() {
		return ext_doc;
	}
	public void setExt_doc(String ext_doc) {
		this.ext_doc = ext_doc;
	}
	public byte[] getContent_doc() {
		return content_doc;
	}
	public void setContent_doc(byte[] content_doc) {
		this.content_doc = content_doc;
	}
	public User getFormateur() {
		return formateur;
	}
	public void setFormateur(User user) {
		this.formateur = user;
	}
	
	
	


}
