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

import com.colar.spring_project.dto.BoardDTO;
import com.colar.spring_project.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	// 목록 조회 (검색 파라미터 포함)
	@GetMapping
	public ResponseEntity<List<BoardDTO>> getList(BoardDTO boardDto) {
		return ResponseEntity.ok(boardService.getList(boardDto));
	}

	// 단건 조회
	@GetMapping("/{boardSeq}")
	public ResponseEntity<BoardDTO> getDetail(@PathVariable Long boardSeq) {
		BoardDTO result = boardService.getDetail(boardSeq);
		if (result == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(result);
	}

	// 등록
	@PostMapping
	public ResponseEntity<BoardDTO> insert(@RequestBody BoardDTO boardDto) {
		boardService.insert(boardDto);
		return ResponseEntity.ok(boardDto);
	}

	// 수정
	@PutMapping("/{boardSeq}")
	public ResponseEntity<BoardDTO> update(@PathVariable Long boardSeq, @RequestBody BoardDTO boardDto) {
		boardDto.setBoardSeq(boardSeq);
		boardService.update(boardDto);
		return ResponseEntity.ok(boardDto);
	}

	// 삭제
	@DeleteMapping("/{boardSeq}")
	public ResponseEntity<Void> delete(@PathVariable Long boardSeq) {
		boardService.delete(boardSeq);
		return ResponseEntity.ok().build();
	}
}
