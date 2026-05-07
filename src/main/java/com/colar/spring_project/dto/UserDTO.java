package com.colar.spring_project.dto;

import lombok.Data;

@Data
public class UserDTO {
	private Long userSeq;
	private String userId;
	private String userName;
	private String nickname;
	private String password;
	private String userRole;
}
