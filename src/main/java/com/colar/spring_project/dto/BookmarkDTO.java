package com.colar.spring_project.dto;

import lombok.Data;

@Data
public class BookmarkDTO {
	private Long boardSeq; // 게시글 고유번호
	private Long userSeq; // 유저 고유번호
	private boolean isBookmarked; // 즐겨찾기 여부
}
