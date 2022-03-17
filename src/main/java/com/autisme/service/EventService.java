package com.autisme.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import com.autisme.modal.*;

public interface EventService {
	
Event addEvent(Event event);
	
	Event editEvent(Event event, long id);
	
	Event findEventById(long id);
	
	void deleteEvent(long id);
	
	List<Event> findAllEvents();
	
	Event addEventToUser(Event event, long iduser);
	//List<Event> findEventsForCategory(long idCategory);
	

	Event getEvent(Long id);
	Files   storeFile(MultipartFile file,Event event) throws IOException;

	void f(MultipartFile files, Event event);
	
	 List<Event> findEventParticipationForUser( long idUser);

}
