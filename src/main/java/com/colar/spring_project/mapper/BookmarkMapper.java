package com.colar.spring_project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.colar.spring_project.dto.BookmarkDTO;

@Mapper
public interface BookmarkMapper {
	// 즐겨찾기 여부 조회
	int isBookmarked(@Param("boardSeq") Long boardSeq, @Param("userSeq") Long userSeq);
	// 즐겨찾기 등록
	int insert(BookmarkDTO bookmarkDto);
	// 즐겨찾기 취소
	int delete(@Param("boardSeq") Long boardSeq, @Param("userSeq") Long userSeq);
}
