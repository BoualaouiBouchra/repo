package com.autisme.modal;



import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity


public class Participation {
	
	@EmbeddedId
	@JsonIgnore

	ParticipationKey pPK;

	public ParticipationKey getpPK() {
		return pPK;
	}

	public void setpPK(ParticipationKey pPK) {
		this.pPK = pPK;
	}

	public Participation(ParticipationKey pPK) {
		super();
		this.pPK = pPK;
	}
	
	public Participation() {
		
	}
	
}
