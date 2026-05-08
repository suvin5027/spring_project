package com.colar.spring_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.colar.spring_project.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	// 목록 조회 (검색 포함)
	List<BoardDTO> getList(BoardDTO boardDto);
	// 단건 조회
	BoardDTO getDetail(Long boardSeq);
	// 등록
	int insert(BoardDTO boardDto);
	// 수정
	int update(BoardDTO boardDto);
	// 삭제
	int delete(Long boardSeq);
}
