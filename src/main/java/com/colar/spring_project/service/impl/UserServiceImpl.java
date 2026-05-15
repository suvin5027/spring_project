package com.colar.spring_project.service.impl;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.colar.spring_project.dto.UserDTO;
import com.colar.spring_project.mapper.UserMapper;
import com.colar.spring_project.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserMapper userMapper;
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	// 로그인 — DB에서 아이디로 조회 후 비밀번호 일치 여부 확인
	public UserDTO login(UserDTO userDto) {
		UserDTO found = userMapper.login(userDto);
		if (found == null) return null;
		if (!passwordEncoder.matches(userDto.getPassword(), found.getPassword())) return null;
		found.setPassword(null);
		return found;
	}

	// 회원가입 — 비밀번호 BCrypt 암호화 후 저장
	@Override
	public int register(UserDTO userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		return userMapper.register(userDto);
	}

	// 아이디로 회원 조회
	@Override
	public UserDTO findByUserId(String userId) {
		return userMapper.findByUserId(userId);
	}

	// 비밀번호 검증 — userId로 조회 후 BCrypt 비교
	@Override
	public boolean verifyPassword(UserDTO userDto) {
		UserDTO found = userMapper.login(userDto);
		if (found == null) return false;
		return passwordEncoder.matches(userDto.getPassword(), found.getPassword());
	}

	// 아이디 찾기 — 이름 + 이메일 일치 시 아이디 반환
	@Override
	public String findId(UserDTO userDto) {
		return userMapper.findIdByNameAndEmail(userDto);
	}

	// 비밀번호 재설정 — 아이디 + 이메일 일치 시 새 비밀번호로 변경
	@Override
	public boolean resetPassword(UserDTO userDto) {
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		return userMapper.updatePasswordByIdAndEmail(userDto) > 0;
	}

	// 전체 유저 목록 조회 (관리자)
	@Override
	public List<UserDTO> getAdminUserList(UserDTO userDto) {
		return userMapper.getAdminUserList(userDto);
	}

	// 역할 변경 (관리자)
	@Override
	public int updateUserRole(UserDTO userDto) {
		return userMapper.updateUserRole(userDto);
	}

	// 유저 삭제 (관리자)
	@Override
	public int deleteUser(Long userSeq) {
		return userMapper.deleteUser(userSeq);
	}
}
