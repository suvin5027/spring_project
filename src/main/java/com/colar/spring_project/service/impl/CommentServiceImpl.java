package com.colar.spring_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.colar.spring_project.dto.CommentDTO;
import com.colar.spring_project.mapper.CommentMapper;
import com.colar.spring_project.service.CommentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentMapper commentMapper;

	// 게시글 전체 댓글 목록 반환
	@Override
	public List<CommentDTO> getList(Long boardSeq) {
		return commentMapper.getList(boardSeq);
	}

	// 댓글 등록 후 저장된 댓글 반환
	@Override
	public CommentDTO insert(CommentDTO dto) {
		commentMapper.insert(dto);
		return commentMapper.findById(dto.getCommentSeq());
	}

	// 댓글 수정 후 수정된 댓글 반환
	@Override
	public CommentDTO update(CommentDTO dto) {
		commentMapper.update(dto);
		return commentMapper.findById(dto.getCommentSeq());
	}

	// 댓글 삭제 — 관리자가 남의 댓글 삭제 시 무조건 soft delete, 그 외엔 대댓글 여부로 판단
	@Override
	public void delete(Long commentSeq, String deletedBy) {
		if ("ADMIN".equals(deletedBy) || commentMapper.hasChildren(commentSeq) > 0) {
			commentMapper.softDelete(commentSeq, deletedBy);
		} else {
			commentMapper.hardDelete(commentSeq);
		}
	}
}
