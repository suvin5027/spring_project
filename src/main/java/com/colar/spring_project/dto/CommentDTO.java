package com.colar.spring_project.dto;

import lombok.Data;

@Data
public class CommentDTO {
	private Long commentSeq;   // 댓글 고유번호
	private Long boardSeq;     // 게시글 고유번호
	private Long userSeq;      // 작성자 고유번호
	private String author;     // 작성자 닉네임
	private String content;    // 댓글 내용
	private Long parentSeq;    // 부모 댓글 번호 (null이면 최상위 댓글)
	private int depth;         // 깊이 (0: 댓글, 1+: 대댓글)
	private boolean deleted;   // 삭제 여부 (soft delete)
	private String deletedBy;  // 삭제 주체: USER / ADMIN
	private boolean secret;    // 비밀 댓글 여부
	private String createdAt;  // 작성일시
}
