package com.colar.spring_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.colar.spring_project.dto.BookmarkDTO;
import com.colar.spring_project.service.BookmarkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BookmarkController {

	private final BookmarkService bookmarkService;

	// 즐겨찾기 여부 조회
	@GetMapping("/{boardSeq}/bookmark")
	public ResponseEntity<BookmarkDTO> getStatus(
			@PathVariable Long boardSeq,
			@RequestParam Long userSeq) {
		return ResponseEntity.ok(bookmarkService.getStatus(boardSeq, userSeq));
	}

	// 즐겨찾기 토글 (등록/취소)
	@PostMapping("/{boardSeq}/bookmark")
	public ResponseEntity<BookmarkDTO> toggle(
			@PathVariable Long boardSeq,
			@RequestParam Long userSeq) {
		return ResponseEntity.ok(bookmarkService.toggle(boardSeq, userSeq));
	}
}
