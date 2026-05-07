package com.colar.spring_project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.colar.spring_project.dto.UserDTO;

@Mapper
public interface UserMapper {
	UserDTO login(UserDTO userDto);
	int register(UserDTO userDto);
	UserDTO findByUserId(String userId);
}
