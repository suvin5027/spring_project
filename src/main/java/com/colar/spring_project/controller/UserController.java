package com.colar.spring_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colar.spring_project.dto.UserDTO;
import com.colar.spring_project.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	// 로그인
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDto) {
		UserDTO result = userService.login(userDto);
		if (result == null) return ResponseEntity.status(401).build();
		return ResponseEntity.ok(result);
	}

	// 회원가입
	@PostMapping("/register")
	public ResponseEntity<Integer> register(@RequestBody UserDTO userDto) {
		int result = userService.register(userDto);
		return ResponseEntity.ok(result);
	}

	// 비밀번호 검증 — 비밀글 열람 시 본인 확인용
	@PostMapping("/verify-password")
	public ResponseEntity<Void> verifyPassword(@RequestBody UserDTO userDto) {
		boolean result = userService.verifyPassword(userDto);
		if (!result) return ResponseEntity.status(400).build();
		return ResponseEntity.ok().build();
	}
}
