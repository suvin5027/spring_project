package com.colar.spring_project.service;

import java.util.List;

import com.colar.spring_project.dto.UserDTO;

public interface UserService {
	UserDTO login(UserDTO userDto);
	int register(UserDTO userDto);
	UserDTO findByUserId(String userId);
	boolean verifyPassword(UserDTO userDto);
	String findId(UserDTO userDto);
	boolean resetPassword(UserDTO userDto);
	List<UserDTO> getAdminUserList(UserDTO userDto);
	int updateUserRole(UserDTO userDto);
	int deleteUser(Long userSeq);
}
