package com.cg.citipark.service;

import org.springframework.stereotype.Service;

import com.cg.citipark.beans.User;

@Service
public interface UserService {
	public User addUser(User user);
	public User getUserByEmail(String email);
	public User readUserById(Long userId);
	public User deleteUserById(Long userId);
	public User updateUser(User user);
	public boolean login(String loginId,String password);

}
