package com.colar.spring_project.service;

import com.colar.spring_project.dto.BookmarkDTO;

public interface BookmarkService {
	BookmarkDTO getStatus(Long boardSeq, Long userSeq);
	BookmarkDTO toggle(Long boardSeq, Long userSeq);
}
