package com.autisme.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ContactRequest {
	@NotBlank
    private String nom;
 
    @NotBlank
	private String prenom;
    
	@NotBlank
	@Email
	private String email;
	
    @NotBlank
    private String subject;
    
    @NotBlank
    private String message;

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getSubject() {
		return subject;
	}

	public String getMessage() {
		return message;
	}
    
    
}
