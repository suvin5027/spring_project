package com.colar.spring_project.service.impl;

import org.springframework.stereotype.Service;

import com.colar.spring_project.dto.LikeDTO;
import com.colar.spring_project.mapper.LikeMapper;
import com.colar.spring_project.service.LikeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
	private final LikeMapper likeMapper;

	// 좋아요 수 + 오늘 좋아요 여부 조회
	@Override
	public LikeDTO getStatus(Long boardSeq, Long userSeq) {
		LikeDTO dto = new LikeDTO();
		dto.setBoardSeq(boardSeq);
		dto.setUserSeq(userSeq);
		dto.setLikeCount(likeMapper.getLikeCount(boardSeq));
		dto.setLiked(likeMapper.isLikedToday(dto) > 0);
		return dto;
	}

	// 좋아요 등록 — 오늘 이미 눌렀으면 무시, 아니면 누적 등록
	@Override
	public LikeDTO like(Long boardSeq, Long userSeq) {
		LikeDTO dto = new LikeDTO();
		dto.setBoardSeq(boardSeq);
		dto.setUserSeq(userSeq);
		if (likeMapper.isLikedToday(dto) == 0) {
			likeMapper.insert(dto);
		}
		return getStatus(boardSeq, userSeq);
	}
}
