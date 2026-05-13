package com.colar.spring_project.service;

import com.colar.spring_project.dto.LikeDTO;

public interface LikeService {
	LikeDTO getStatus(Long boardSeq, Long userSeq);
	LikeDTO like(Long boardSeq, Long userSeq);
}
