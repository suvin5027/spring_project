package com.colar.spring_project.service;

import java.util.List;

import com.colar.spring_project.dto.CommentDTO;

public interface CommentService {
	List<CommentDTO> getList(Long boardSeq);
	CommentDTO insert(CommentDTO dto);
	CommentDTO update(CommentDTO dto);
	void delete(Long commentSeq, String deletedBy);
}
