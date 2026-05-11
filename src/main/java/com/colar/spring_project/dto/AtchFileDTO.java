package com.colar.spring_project.dto;

import lombok.Data;

@Data
public class AtchFileDTO {
	private Long fileSeq;		// 파일 고유번호
	private Long boardSeq;		// 게시글 고유번호 (FK)
	private String originalName;	// 원본 파일명
	private String savedName;	// 저장된 파일명 (UUID)
	private String filePath;	// 저장 경로
	private Long fileSize;		// 파일 크기 (바이트)
	private String createdAt;	// 등록일시
}
