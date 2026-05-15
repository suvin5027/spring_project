package com.colar.spring_project.dto;

import lombok.Data;

@Data
public class ReportDTO {
	private Long   reportSeq;    // 신고 고유번호
	private String targetType;   // 신고 대상 타입 (BOARD / COMMENT)
	private Long   targetSeq;    // 신고 대상 PK
	private Long   reporterSeq;  // 신고자 USER_SEQ
	private String reason;       // 신고 사유 (ABUSE / SPAM / OBSCENE / ETC)
	private String status;       // 처리 상태 (PENDING / PROCESSED)
	private String createdAt;    // 신고일

	// 관리자 목록 표시용
	private String reporterNickname; // 신고자 닉네임
	private String targetTitle;      // 대상 게시글 제목 또는 댓글 내용 (앞 30자)
}
