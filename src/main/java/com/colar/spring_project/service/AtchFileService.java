package com.colar.spring_project.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.colar.spring_project.dto.AtchFileDTO;

public interface AtchFileService {
	void upload(Long boardSeq, List<MultipartFile> files) throws Exception;
	List<AtchFileDTO> getFiles(Long boardSeq);
	Resource download(Long fileSeq) throws Exception;
	AtchFileDTO getFileInfo(Long fileSeq);
	void delete(Long fileSeq) throws Exception;
}
