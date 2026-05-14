package com.colar.spring_project.dto;

import lombok.Data;

@Data
public class BoardDTO {
	private Long boardSeq;		// 게시글 고유번호
	private Long userSeq;		// 작성자 고유번호 (FK)
	private String category;	// 카테고리 (notice/general/question)
	private String title;		// 제목
	private String content;		// 내용 (HTML)
	private Integer isSecret;	// 비밀글 여부 (0/1)
	private Integer viewCount;	// 조회수
	private String author;		// 작성자 닉네임 (JOIN)
	private String createdAt;	// 등록일시

	private Integer hasAttachment;	// 첨부파일 여부 (0/1)
	private Integer likeCount;		// 좋아요 수
	private Integer commentCount;	// 댓글 수

	// 검색용 파라미터
	private String searchType;	// 검색 유형 (title/content/author)
	private String keyword;		// 검색어
}
