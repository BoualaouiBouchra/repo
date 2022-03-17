package com.autisme.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.autisme.modal.*;

import com.autisme.service.*;

@RestController
@RequestMapping(value = "/api/public")
@CrossOrigin(origins = "http://localhost:4200/")
public class EventController {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private FilesService filesService;
	@Autowired
	private UserService userService;
	@Autowired
	private  ParticipationService partDao;
	
	@GetMapping("/findFilesAll")
	List<Files> findAllFiless() {
		List<Files> ff=	filesService.findAllFiless();
		System.out.println(ff.get(0).getNom());
		
		
		return filesService.findAllFiless();
	}
	
	@GetMapping("/findFilesbyEvent/{id}")
	List<Files> findFilesbyEvent(@PathVariable long id) {
	
		return filesService.findFilessForEvent(id);
	}
	
	@GetMapping("/findEventParticipationForUser/{id}")
	List<Event> findEventParticipationForUser(@PathVariable long id) {
	
		return eventService.findEventParticipationForUser(id);
	}
	
	@GetMapping("/findOneFilebyEvent/{id}")
	Files findOneFilebyEvent(@PathVariable long id) {
	
		return filesService.findOneFileForEvent(id);
	}
	
	@GetMapping("/findAllEvents")
	List<Event> findAllEvents() {
	
		return eventService.findAllEvents();
	}
	
	
	@GetMapping("/findEventById/{id}")
	Event findEventById(@PathVariable long id) {
		
		
		return eventService.findEventById(id);
	}
	
	@DeleteMapping("/Img/delete/{id}")
	ResponseEntity<Event> deleteEvent(@PathVariable long id) {
		filesService.deleteFiles(id);
		 return new ResponseEntity<Event>( HttpStatus.OK); 
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	@PutMapping("/partic/{id}")
	  ResponseEntity<Participation> particEvent(@PathVariable long id,@RequestPart("userId") long userId) {
		
		User u= userService.findUserById(userId);
		Event e=eventService.findEventById(id);
		System.out.println(e.toString());
		ParticipationKey pk =new ParticipationKey(e, u);
		Participation p=new Participation(pk);
		Participation p1=	partDao.addParti(p,pk);
		
		 return new ResponseEntity<Participation>(p1,HttpStatus.OK); 
	}
	
	@DeleteMapping("/delete/{id}")
	 ResponseEntity<Event> deleteImg(@PathVariable long id) {
		eventService.deleteEvent(id);
		 return new ResponseEntity<Event>(HttpStatus.OK); 
		
	}
	@PutMapping("/editEvent/{id}")
	ResponseEntity<Event> editProduct(@RequestBody Event event, @PathVariable long id) {
		 
			Event e=	 eventService.editEvent(event, id);
				 return new ResponseEntity<Event>( e,HttpStatus.OK); 
	}

	
	@PostMapping( value ="/addEvent",
			produces = MediaType.APPLICATION_JSON_VALUE,
		    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE}
)
	/* void add(@RequestPart("event") Event event, @RequestPart("file[]") MultipartFile file) {
		eventService.f(file,event);
		
	}*/
	
	
	ResponseEntity<Event> add(@RequestPart("event1") Event event1,@RequestPart("event") Event event, @RequestPart("file[]") MultipartFile[] file) {
		System.out.println(event.getTitle());
		System.out.println(event1.getTitle());
		if (eventService.addEvent(event)!= null) {
		for(int i=0;i<file.length;i++){
            System.out.println(file[i].getOriginalFilename());
            eventService.f(file[i],event);
             }}
		   return new ResponseEntity<Event>( HttpStatus.OK);
		
	}
	@PutMapping( value ="/editE/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE,
		    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
	
	ResponseEntity<Event> addImgedit(@RequestPart("event") Event event, @RequestPart("file[]") MultipartFile[] file, @PathVariable long id) {
			System.out.println(event.getTitle());
			List<Files> dbFile  = new ArrayList<>();
			for(int i=0;i<file.length;i++){
				 String fileName = StringUtils.cleanPath(file[i].getOriginalFilename());
				 try {
					
					 dbFile.add (new Files(fileName, file[i].getContentType(),  file[i].getContentType(),file[i].getBytes(),event));
				
					 
					  } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  }
			//event.addFilesToEvent(file);
			 event.setFiles(dbFile);
			eventService.editEvent(event, id);
		/*	for(int i=0;i<file.length;i++){
	            System.out.println(file[i].getOriginalFilename());
	            eventService.f(file[i],event);
	             }*/
			 return new ResponseEntity<Event>( HttpStatus.OK);
		}
}
