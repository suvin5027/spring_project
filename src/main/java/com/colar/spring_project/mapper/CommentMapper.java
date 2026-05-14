package com.colar.spring_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.colar.spring_project.dto.CommentDTO;

@Mapper
public interface CommentMapper {
	// 게시글 전체 댓글 목록 조회
	List<CommentDTO> getList(@Param("boardSeq") Long boardSeq);

	// 댓글 단건 조회 (수정/삭제 권한 확인용)
	CommentDTO findById(@Param("commentSeq") Long commentSeq);

	// 댓글 등록
	int insert(CommentDTO dto);

	// 댓글 수정
	int update(CommentDTO dto);

	// soft delete — 대댓글 있을 때 "삭제된 댓글입니다" 표시
	int softDelete(@Param("commentSeq") Long commentSeq);

	// hard delete — 대댓글 없을 때 완전 삭제
	int hardDelete(@Param("commentSeq") Long commentSeq);

	// 대댓글 존재 여부 확인
	int hasChildren(@Param("commentSeq") Long commentSeq);

	// 게시글 댓글 수 조회 (BoardList 표시용)
	int getCommentCount(@Param("boardSeq") Long boardSeq);
}
