package com.autisme.modal;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
@Table(name = "files")
public class Files {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id_fil;

	 private String nom;

	 private String type;

	 private String ext;
	  @Lob
	  private byte[] content;
	  
	  @JsonBackReference(value = "event")
		@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.DETACH,
			      CascadeType.REFRESH }
		   )
	    private Event event;

	public Long getId_fil() {
		return id_fil;
	}

	public void setId_fil(Long id_fil) {
		this.id_fil = id_fil;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Files(Long id_fil, String nom, String type, String ext,  byte[] content, Event event) {
		super();
		this.id_fil = id_fil;
		this.nom = nom;
		this.type = type;
		this.ext = ext;
		this.content = content;
		this.event = event;
	}
	
	public Files( String nom, String type, String ext,  byte[] content, Event event) {
		super();
		
		this.nom = nom;
		this.type = type;
		this.ext = ext;
		this.content = content;
		this.event = event;
	}

	public Files( String nom, String type, String ext,  byte[] content) {
		super();
		
		this.nom = nom;
		this.type = type;
		this.ext = ext;
		this.content = content;
	
	}
	public Files() {
		super();
	}
	  
	  

}
