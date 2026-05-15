package com.colar.spring_project.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colar.spring_project.dto.BoardDTO;
import com.colar.spring_project.dto.UserDTO;
import com.colar.spring_project.service.BoardService;
import com.colar.spring_project.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

	private final UserService userService;
	private final BoardService boardService;

	// 전체 유저 목록 조회 (검색 포함)
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> getAdminUserList(UserDTO userDto) {
		return ResponseEntity.ok(userService.getAdminUserList(userDto));
	}

	// 유저 역할 변경 (USER ↔ ADMIN)
	@PutMapping("/users/{userSeq}/role")
	public ResponseEntity<Void> updateUserRole(@PathVariable Long userSeq, @RequestBody UserDTO userDto) {
		userDto.setUserSeq(userSeq);
		userService.updateUserRole(userDto);
		return ResponseEntity.ok().build();
	}

	// 유저 삭제
	@DeleteMapping("/users/{userSeq}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long userSeq) {
		userService.deleteUser(userSeq);
		return ResponseEntity.ok().build();
	}

	// 전체 게시글 목록 조회 (카테고리 필터 포함)
	@GetMapping("/boards")
	public ResponseEntity<List<BoardDTO>> getAdminBoardList(BoardDTO boardDto) {
		return ResponseEntity.ok(boardService.getList(boardDto));
	}

	// 게시글 강제 삭제
	@DeleteMapping("/boards/{boardSeq}")
	public ResponseEntity<Void> deleteBoard(@PathVariable Long boardSeq) {
		boardService.delete(boardSeq);
		return ResponseEntity.ok().build();
	}
}
