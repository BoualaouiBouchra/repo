package com.autisme.modal;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable


public class ParticipationKey implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional=false, fetch = FetchType.LAZY)
	@JoinColumn(name="id_envent")
	private Event event;
	
	@ManyToOne(optional=false, fetch = FetchType.LAZY)
	@JoinColumn(name="id_user")
	private User user;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ParticipationKey() {
		
	}
	public ParticipationKey(Event event, User user) {
		super();
		this.event = event;
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipationKey other = (ParticipationKey) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	

}
