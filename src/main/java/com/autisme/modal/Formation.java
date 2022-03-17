package com.autisme.modal;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="formations") 
public class Formation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id; 
	
	@Column(name="date")
	private Date date;
	
	@Column(name="titre")
	private String titre;
	
	@Column(name="titre_arab")
	private String titre_arab;
	@Column(name="description")
	private String description;
	
	@Column(name="description_arab")
	private String description_arab;
	
	@Column(name="etat")
	private int etat;
	
	@JsonBackReference(value = "formateur")
	 @ManyToOne(cascade = CascadeType.PERSIST)
	 private User formateur;
	
    public Formation() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public User getFormateur() {
		return formateur;
	}

	public void setFormateur(User formateur2) {
		this.formateur = formateur2;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTitre_arab() {
		return titre_arab;
	}

	public void setTitre_arab(String titre_arab) {
		this.titre_arab = titre_arab;
	}

	public String getDescription_arab() {
		return description_arab;
	}

	public void setDescription_arab(String description_arab) {
		this.description_arab = description_arab;
	}

	public Formation(Long id, Date date, String titre, String titre_arab, String description, String description_arab,
			int etat, User formateur) {
		super();
		this.id = id;
		this.date = date;
		this.titre = titre;
		this.titre_arab = titre_arab;
		this.description = description;
		this.description_arab = description_arab;
		this.etat = etat;
		this.formateur = formateur;
	}

	public Formation(Date date, String titre, String titre_arab, String description, String description_arab, int etat,
			User formateur) {
		super();
		this.date = date;
		this.titre = titre;
		this.titre_arab = titre_arab;
		this.description = description;
		this.description_arab = description_arab;
		this.etat = etat;
		this.formateur = formateur;
	}
	
	
    
}

