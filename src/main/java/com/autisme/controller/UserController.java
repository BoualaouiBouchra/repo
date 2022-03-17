package com.autisme.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import com.autisme.modal.Files;
import com.autisme.modal.User;
import com.autisme.service.UserService;




@RestController
@RequestMapping("/api/public/user2")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

	private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers () {
        List<User> users = userService.findAllUsers();
        
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
  

    @GetMapping("/allUsersNotValidate")
    public ResponseEntity<List<User>> getAllUsersNotV () {
    	
        List<User> users = userService.findAllUsersNotV();

        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newEmployee = userService.addUser(user);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }
    @PutMapping("/updateProfile")
    public User updateUserProfile(@RequestBody User user) {
    	
    User response=userService.updateUserProfile(user);
        return response;
    }

  
    @PutMapping("/onActiveNotif")  
    public int  onActiveUserNotif(@RequestBody User user) {
    	
    	int response = userService.onActiveNotif(user);
    	return response;
    }
    @PutMapping("/onActiveUserAccount")  
    public int  onActiveUser(@RequestBody User user) {
    	
    	int response = userService.onActiveUser(user);
    	return response;
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}