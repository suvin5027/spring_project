package com.colar.spring_project.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colar.spring_project.dto.CommentDTO;
import com.colar.spring_project.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	// 게시글 전체 댓글 목록 조회
	@GetMapping("/{boardSeq}/comments")
	public ResponseEntity<List<CommentDTO>> getList(@PathVariable Long boardSeq) {
		return ResponseEntity.ok(commentService.getList(boardSeq));
	}

	// 댓글 등록
	@PostMapping("/{boardSeq}/comments")
	public ResponseEntity<CommentDTO> insert(
			@PathVariable Long boardSeq,
			@RequestBody CommentDTO dto) {
		dto.setBoardSeq(boardSeq);
		return ResponseEntity.ok(commentService.insert(dto));
	}

	// 댓글 수정
	@PutMapping("/{boardSeq}/comments/{commentSeq}")
	public ResponseEntity<CommentDTO> update(
			@PathVariable Long boardSeq,
			@PathVariable Long commentSeq,
			@RequestBody CommentDTO dto) {
		dto.setCommentSeq(commentSeq);
		return ResponseEntity.ok(commentService.update(dto));
	}

	// 댓글 삭제 — 대댓글 있으면 soft delete, 없으면 hard delete
	@DeleteMapping("/{boardSeq}/comments/{commentSeq}")
	public ResponseEntity<Void> delete(
			@PathVariable Long boardSeq,
			@PathVariable Long commentSeq) {
		commentService.delete(commentSeq);
		return ResponseEntity.ok().build();
	}
}
