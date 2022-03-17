package com.autisme.modal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
public class Event implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_envent;

	 private String title;

	  private String description;
	  
		 private String title_arab;

		  private String description_arab;
		 
	 

	  private Date date_event;
	 

	 @JsonProperty(access = Access.WRITE_ONLY)
	 @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
	 private List<Files> files;
	 
	 
	 @OneToMany(mappedBy="pPK.event", cascade = CascadeType.ALL)
	 private List<Participation> paticipants = new ArrayList<Participation>();
	 
	

	 
	 

	public Event(String title, String description, String title_arab, String description_arab, Date date_event,
			List<Files> files, List<Participation> paticipants) {
		super();
		this.title = title;
		this.description = description;
		this.title_arab = title_arab;
		this.description_arab = description_arab;
		this.date_event = date_event;
		this.files = files;
		this.paticipants = paticipants;
	}






	public Event(Long id_envent, String title, String description, String title_arab, String description_arab,
			Date date_event, List<Files> files, List<Participation> paticipants) {
		super();
		this.id_envent = id_envent;
		this.title = title;
		this.description = description;
		this.title_arab = title_arab;
		this.description_arab = description_arab;
		this.date_event = date_event;
		this.files = files;
		this.paticipants = paticipants;
	}






	public String getTitle_arab() {
		return title_arab;
	}






	public void setTitle_arab(String title_arab) {
		this.title_arab = title_arab;
	}






	public String getDescription_arab() {
		return description_arab;
	}






	public void setDescription_arab(String description_arab) {
		this.description_arab = description_arab;
	}






	public List<Participation> getPaticipants() {
		return paticipants;
	}






	public Event(Long id_envent, String title, String description, Date date_event, List<Files> files,
			List<Participation> paticipants) {
		super();
		this.id_envent = id_envent;
		this.title = title;
		this.description = description;
		this.date_event = date_event;
		this.files = files;
		this.paticipants = paticipants;
	}






	public void setPaticipants(List<Participation> paticipants) {
		this.paticipants = paticipants;
	}






	public Event(Long id_envent, String title, String description, Date date_event, List<Files> files) {
		super();
		this.id_envent = id_envent;
		this.title = title;
		this.description = description;
		this.date_event = date_event;
		this.files = files;
	}



	


	public Date getDate_event() {
		return date_event;
	}



	public void setDate_event(Date date_event) {
		this.date_event = date_event;
	}




	


	public List<Files> getFiles() {
		return files;
	}



	public void setFiles(List<Files> files) {
		this.files = files;
	}



	public Long getId_envent() {
			return id_envent;
		}



		public void setId_envent(Long id_envent) {
			this.id_envent = id_envent;
		}



		public String getTitle() {
			return title;
		}



		public void setTitle(String title) {
			this.title = title;
		}



		public String getDescription() {
			return description;
		}



		public void setDescription(String description) {
			this.description = description;
		}



	


		public static long getSerialversionuid() {
			return serialVersionUID;
		}



		public Event(Long id_envent, String title, String description, Date date) {
			super();
			this.id_envent = id_envent;
			this.title = title;
			this.description = description;
			this.date_event = date;
		}



		public Event() {
			super();
		}



		@Override
		public String toString() {
			return "Event [id_envent=" + id_envent + ", title=" + title + ", description=" + description
					+ ", date_event=" + date_event + ", files=" + files + "]";
		}
		
		
		
		
		public void addFilesToEvent(Files f) {
			if (getFiles()==null) {
				this.files = new ArrayList<>();
			}
			getFiles().add(f);
			f.setEvent(this);
		}
		 

		
		
}
