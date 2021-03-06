package com.cg.citipark.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.citipark.beans.User;
import com.cg.citipark.service.MapValidationErrorService;
import com.cg.citipark.service.UserService;

@RestController	
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	/*
	 * Add user 
	 */
	@PostMapping("/user/adduser")
	public ResponseEntity<?> addUser(@Valid @RequestBody User user,BindingResult result)
	{
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null) 
			return errorMap;
		User registerUser = userService.addUser(user);
		return new ResponseEntity<User>(registerUser, HttpStatus.OK);
	}
	
	/*
	 * Get user details by Email
	 */
	@GetMapping("/user/getUserByEmail/{email}")
	public  ResponseEntity<?> getUserByEmail(@PathVariable String email)
	{
		
		return new ResponseEntity<User>(userService.getUserByEmail(email), HttpStatus.OK);
	}
	
	/*
	 * Get user details by Id
	 */
	@GetMapping("/user/getUserById/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long userId) {
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	/*
	 * Delete user by Id
	 */
	@DeleteMapping("/user/delete/{id}")
	public void deleteUserById(@PathVariable Long userId)
	{
		userService.deleteUserById(userId);
	}
	
	/*
	 * Update user details
	 */
	@PutMapping("/user/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}

}
