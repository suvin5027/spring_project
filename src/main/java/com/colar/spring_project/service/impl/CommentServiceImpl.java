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

	// 댓글 삭제 — 대댓글 있으면 soft delete, 없으면 hard delete
	@Override
	public void delete(Long commentSeq) {
		if (commentMapper.hasChildren(commentSeq) > 0) {
			commentMapper.softDelete(commentSeq);
		} else {
			commentMapper.hardDelete(commentSeq);
		}
	}
}
