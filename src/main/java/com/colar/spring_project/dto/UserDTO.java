package com.colar.spring_project.dto;

import lombok.Data;

@Data
public class UserDTO {
	private Long userSeq;		// 회원 고유번호
	private String userId;		// 아이디
	private String userName;	// 이름
	private String nickname;	// 닉네임
	private String email;		// 이메일
	private String password;	// 비밀번호
	private String userRole;	// 권한 (USER / ADMIN)
	private String createdAt;		// 가입일 (관리자 목록 표시용)
	private String lastLoginAt;	// 마지막 접속 시간 (관리자 목록 표시용)

	// 검색용 파라미터
	private String keyword;		// 검색어 (아이디/이름/닉네임)
}
