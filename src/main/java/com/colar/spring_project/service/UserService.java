package com.colar.spring_project.service;

import com.colar.spring_project.dto.UserDTO;

public interface UserService {
	UserDTO login(UserDTO userDto);
	int register(UserDTO userDto);
	UserDTO findByUserId(String userId);
	boolean verifyPassword(UserDTO userDto);
	String findId(UserDTO userDto);
	boolean resetPassword(UserDTO userDto);
}
