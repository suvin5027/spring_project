package com.colar.spring_project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.colar.spring_project.dto.LikeDTO;

@Mapper
public interface LikeMapper {
	// 좋아요 수 조회
	int getLikeCount(Long boardSeq);
	// 오늘 좋아요 여부 조회
	int isLikedToday(LikeDTO likeDto);
	// 좋아요 등록
	int insert(LikeDTO likeDto);
}
