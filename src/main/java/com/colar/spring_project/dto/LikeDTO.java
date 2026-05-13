package com.colar.spring_project.dto;

import lombok.Data;

@Data
public class LikeDTO {
	private Long boardSeq;	// 게시글 고유번호
	private Long userSeq;	// 유저 고유번호
	private int likeCount;	// 좋아요 수
	private boolean isLiked;	// 현재 유저 좋아요 여부
}
