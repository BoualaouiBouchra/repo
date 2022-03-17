package com.autisme.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.autisme.dao.UserRepository;
import com.autisme.exception.UserNotFoundException;
import com.autisme.modal.User;



@Service
@Transactional
public class UserService {

	  private final UserRepository userRepo;

	    @Autowired
	    public UserService(UserRepository userRepo) {
	        this.userRepo = userRepo;
	    }
	    
	    public List<User> findAllUsers() {
	        return userRepo.findAll();
	    }
	    
	    public List<User> findAllUsersNotV() {
	        return  userRepo.findAllNotV();
	    }
	    
	    public List<User> findAllUsersNotifier() {
	        return userRepo.findAllNotifier();
	    }

	    public User addUser(User user) {
	      
	    	//employee.setEmployeeCode(UUID.randomUUID().toString());
	        return userRepo.save(user);
	    }


	    public User updateUser(User user) {
	        return userRepo.save(user);
	    }
    public User updateUserProfile(User user) {
    //	return 	userRepo.updateProfile(user.getId(),user.getAdress());
	      
    	//return 	userRepo.updateProfile(user.getId(),user);
	      User u=	 userRepo.findById(user.getId()).orElse(null);
	      
    			if ( u!=null) {
    				u.setAdress(user.getAdress());
    				u.setPrenom(user.getPrenom());
    				
    				u.setTele(user.getTele());
    				return userRepo.save(u);
    		    }
    			return null;
    			}
    			
    			
	        
	    
	    
	/*    public int updateUserProfile(User user) {
	    	
	        return userRepo.updateProfile(user.getId(),user.getPrenom(),user.getAdress(),user.getTele());
	        
	    }*/
	
	    public int onActiveNotif(User user) {
	    	
	        return userRepo.onActiveUserNotif(user.getId());
	    }
	    
	    public int onActiveUser(User user) {
	    	
	        return userRepo.onActiveUserAccount(user.getId());
	    }
	    
	    public User findUserById(long id) {
	        return userRepo.findUserById(id)
	                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	    }
	 

	    public void deleteUser(Long id){
	    	userRepo.deleteUserById(id);
	    }
	    

}
