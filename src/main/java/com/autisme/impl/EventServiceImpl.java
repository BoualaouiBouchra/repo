package com.autisme.impl;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import com.autisme.dao.*;
import com.autisme.modal.*;
import com.autisme.service.*;



@Transactional
@Component


public class EventServiceImpl implements EventService {
	
	
	
	@Autowired 
	private EventDao eventDao;

	@Autowired 
	private FilesDao filesDao;

	@Autowired 
	private UserDao userDao;

	
	@Override
	public Event editEvent(Event event, long id) {
		Event existEvent = eventDao.findById(id).orElse(null);
		existEvent.setTitle(event.getTitle());
		existEvent.setDescription(event.getDescription());
		existEvent.setDate_event(event.getDate_event());
		existEvent.setDescription_arab(event.getDescription_arab()); 
		existEvent.setTitle_arab(event.getTitle_arab());  
		if (event.getFiles()!=null && event.getFiles().size()!=0) 
		{existEvent.setFiles(event.getFiles());}
		return eventDao.save(existEvent);
	}

	@Override
	public Event findEventById(long id) {
		return eventDao.findById(id).orElse(null);
	}

	@Override
	public void deleteEvent(long id) {
	eventDao.deleteById(id);
		
	}

	@Override
	public List<Event> findAllEvents() {
		
		return eventDao.findAll();
	}

	@Override
	public Event getEvent(Long id) {
		
		return eventDao.findById(id).orElse(null);
	}
	
	@Override
	
	
public void f(MultipartFile files,Event event)  {
	 event.setFiles(Arrays.asList(files)
     .stream()
     .map(file -> {
		try {
			return storeFile(file,event);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	})
     .collect(Collectors.toList()));
}
	@Override
	public Files storeFile(MultipartFile file,Event event) throws IOException {
		 String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	  
	            // Check if the file's name contains invalid characters
	           System.out.println(" event "+ event.getDescription());
		
	           Files dbFile = new Files(fileName, file.getContentType(),  file.getContentType(),file.getBytes(),event);

	           return  filesDao.save(dbFile);
	         // event.setFiles(f);
	        //  event;
	       
	    }

	@Override
	public Event addEventToUser(Event event, long iduser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> findEventParticipationForUser(long idUser) {
		
		return eventDao.findEventParticipationForUser(idUser);
	}

	@Override
	public Event addEvent(Event event) {
		
		return eventDao.save(event);
	}
}
