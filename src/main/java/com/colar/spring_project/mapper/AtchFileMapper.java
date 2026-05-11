package com.colar.spring_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.colar.spring_project.dto.AtchFileDTO;

@Mapper
public interface AtchFileMapper {
	int insert(AtchFileDTO atchFileDto);
	List<AtchFileDTO> getFilesByBoardSeq(Long boardSeq);
	AtchFileDTO getFileByFileSeq(Long fileSeq);
	int deleteByFileSeq(Long fileSeq);
}
