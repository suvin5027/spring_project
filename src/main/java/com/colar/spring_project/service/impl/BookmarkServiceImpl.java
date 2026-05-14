package com.colar.spring_project.service.impl;

import org.springframework.stereotype.Service;

import com.colar.spring_project.dto.BookmarkDTO;
import com.colar.spring_project.mapper.BookmarkMapper;
import com.colar.spring_project.service.BookmarkService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookmarkServiceImpl implements BookmarkService {

	private final BookmarkMapper bookmarkMapper;

	// 즐겨찾기 여부 조회 후 DTO 반환
	@Override
	public BookmarkDTO getStatus(Long boardSeq, Long userSeq) {
		BookmarkDTO dto = new BookmarkDTO();
		dto.setBoardSeq(boardSeq);
		dto.setUserSeq(userSeq);
		dto.setBookmarked(bookmarkMapper.isBookmarked(boardSeq, userSeq) > 0);
		return dto;
	}

	// 즐겨찾기 등록/취소 토글 후 현재 상태 반환
	@Override
	public BookmarkDTO toggle(Long boardSeq, Long userSeq) {
		boolean bookmarked = bookmarkMapper.isBookmarked(boardSeq, userSeq) > 0;
		BookmarkDTO dto = new BookmarkDTO();
		dto.setBoardSeq(boardSeq);
		dto.setUserSeq(userSeq);
		if (bookmarked) {
			bookmarkMapper.delete(boardSeq, userSeq);
			dto.setBookmarked(false);
		} else {
			bookmarkMapper.insert(dto);
			dto.setBookmarked(true);
		}
		return dto;
	}
}
