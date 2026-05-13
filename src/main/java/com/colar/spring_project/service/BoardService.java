package com.colar.spring_project.service;

import java.util.List;

import com.colar.spring_project.dto.BoardDTO;

public interface BoardService {
	List<BoardDTO> getList(BoardDTO boardDto);
	BoardDTO getDetail(Long boardSeq);
	int insert(BoardDTO boardDto);
	int update(BoardDTO boardDto);
	int delete(Long boardSeq);
	int incrementViewCount(Long boardSeq);
}
