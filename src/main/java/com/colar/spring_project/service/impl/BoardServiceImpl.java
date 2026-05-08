package com.colar.spring_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.colar.spring_project.dto.BoardDTO;
import com.colar.spring_project.mapper.BoardMapper;
import com.colar.spring_project.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper boardMapper;

	// 목록 조회
	@Override
	public List<BoardDTO> getList(BoardDTO boardDto) {
		return boardMapper.getList(boardDto);
	}

	// 단건 조회
	@Override
	public BoardDTO getDetail(Long boardSeq) {
		return boardMapper.getDetail(boardSeq);
	}

	// 등록
	@Override
	public int insert(BoardDTO boardDto) {
		return boardMapper.insert(boardDto);
	}

	// 수정
	@Override
	public int update(BoardDTO boardDto) {
		return boardMapper.update(boardDto);
	}

	// 삭제
	@Override
	public int delete(Long boardSeq) {
		return boardMapper.delete(boardSeq);
	}
}
