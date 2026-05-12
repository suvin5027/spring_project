package com.colar.spring_project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.colar.spring_project.dto.UserDTO;

@Mapper
public interface UserMapper {
	// 로그인
	UserDTO login(UserDTO userDto);
	// 회원가입
	int register(UserDTO userDto);
	// 아이디로 회원 조회
	UserDTO findByUserId(String userId);
	// 이름 + 이메일로 아이디 찾기
	String findIdByNameAndEmail(UserDTO userDto);
	// 아이디 + 이메일로 회원 존재 확인 후 비밀번호 변경
	int updatePasswordByIdAndEmail(UserDTO userDto);
}
