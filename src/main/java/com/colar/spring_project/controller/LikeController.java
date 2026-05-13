package com.colar.spring_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.colar.spring_project.dto.LikeDTO;
import com.colar.spring_project.service.LikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class LikeController {

	private final LikeService likeService;

	// 좋아요 상태 조회 (좋아요 수 + 현재 유저 좋아요 여부)
	@GetMapping("/{boardSeq}/like")
	public ResponseEntity<LikeDTO> getStatus(
			@PathVariable Long boardSeq,
			@RequestParam Long userSeq) {
		return ResponseEntity.ok(likeService.getStatus(boardSeq, userSeq));
	}

	// 좋아요 등록 (하루 1회, 오늘 이미 눌렀으면 무시)
	@PostMapping("/{boardSeq}/like")
	public ResponseEntity<LikeDTO> like(
			@PathVariable Long boardSeq,
			@RequestParam Long userSeq) {
		return ResponseEntity.ok(likeService.like(boardSeq, userSeq));
	}
}
