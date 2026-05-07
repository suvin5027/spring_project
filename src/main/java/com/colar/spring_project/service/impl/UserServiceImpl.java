package com.colar.spring_project.service.impl;

import org.springframework.stereotype.Service;

import com.colar.spring_project.dto.UserDTO;
import com.colar.spring_project.mapper.UserMapper;
import com.colar.spring_project.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;

	// 로그인
	public UserDTO login(UserDTO userDto) {
		return userMapper.login(userDto);
	}

	// 회원가입
	@Override
	public int register(UserDTO userDto) {
		return userMapper.register(userDto);
	}

	// 아이디로 회원 조회
	@Override
	public UserDTO findByUserId(String userId) {
		return userMapper.findByUserId(userId);
	}
}
