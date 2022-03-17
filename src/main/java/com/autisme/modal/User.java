package com.autisme.modal;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(	name = "utilisateur", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 20)
	private String prenom;

	
	@NotBlank
	private String adress;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	
	@NotBlank
	private String tele;
	
    private int notif;
   
    private int active;
    
    @JsonProperty(access = Access.WRITE_ONLY)
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "formateur")
	 private List<Document> docs;
    
	@JsonProperty(access = Access.WRITE_ONLY)
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "formateur")
	 private List<Formation> formation;
	 


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public List<Formation> getFormation() {
		return formation;
	}

	public void setFormation(List<Formation> formation) {
		this.formation = formation;
	}

	public void addFormationToFormateur(Formation formations) {
		if (getFormation()==null) {
		    this.formation = new ArrayList<>();
		}
		  getFormation().add(formations);
		  formations.setFormateur(this);
		 }
	
	

	public List<Document> getDocs() {
		return docs;
	}

	public void setDocs(List<Document> docs) {
		this.docs = docs;
	}
	
	
	public void addDocToFormateur(Document f) {
		if (getDocs()==null) {
			this.docs = new ArrayList<>();
		}
		getDocs().add(f);
		f.setFormateur(this);
	}
	

	public Long getId() {
		return id;
	}
	
	public User(String username,String prenom,String adress,String email,String password, String tele) {
	
		this.username = username;
		this.prenom = prenom;
		this.adress = adress;
		this.email = email;
		this.password = password;
		this.tele = tele;
	}
	public User(String username,String prenom,String adress,String email, String tele) {
		
		this.username = username;
		this.prenom = prenom;
		this.adress = adress;
		this.email = email;
		this.tele = tele;
	}
	

	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 20) String prenom,
			@NotBlank String adress, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, @NotBlank String tele, Set<Role> roles) {
		super();
		this.username = username;
		this.prenom = prenom;
		this.adress = adress;
		this.email = email;
		this.password = password;
		this.tele = tele;
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public int getNotif() {
		return notif;
	}

	public void setNotif(int notif) {
		this.notif = notif;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", prenom=" + prenom + ", adress=" + adress + ", email="
				+ email + ", password=" + password + ", tele=" + tele + ", notif=" + notif + ", active=" + active
				+ ", roles=" + roles + "]";
	}


	


	
}