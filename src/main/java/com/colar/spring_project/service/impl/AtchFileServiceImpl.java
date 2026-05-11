package com.colar.spring_project.service.impl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.colar.spring_project.dto.AtchFileDTO;
import com.colar.spring_project.mapper.AtchFileMapper;
import com.colar.spring_project.service.AtchFileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtchFileServiceImpl implements AtchFileService {

	private final AtchFileMapper atchFileMapper;

	@Value("${file.upload.path}")
	private String uploadPath;

	// 파일 업로드 — UUID로 저장명 생성 후 지정 경로에 저장, DB 등록
	@Override
	public void upload(Long boardSeq, List<MultipartFile> files) throws Exception {
		File dir = new File(uploadPath);
		if (!dir.exists()) dir.mkdirs();

		for (MultipartFile file : files) {
			String originalName = file.getOriginalFilename();
			String ext = originalName.substring(originalName.lastIndexOf("."));
			String savedName = UUID.randomUUID().toString() + ext;

			file.transferTo(new File(uploadPath + File.separator + savedName));

			AtchFileDTO dto = new AtchFileDTO();
			dto.setBoardSeq(boardSeq);
			dto.setOriginalName(originalName);
			dto.setSavedName(savedName);
			dto.setFilePath(uploadPath);
			dto.setFileSize(file.getSize());

			atchFileMapper.insert(dto);
		}
	}

	// 게시글별 파일 목록 조회
	@Override
	public List<AtchFileDTO> getFiles(Long boardSeq) {
		return atchFileMapper.getFilesByBoardSeq(boardSeq);
	}

	// 파일 다운로드용 Resource 반환
	@Override
	public Resource download(Long fileSeq) throws Exception {
		AtchFileDTO dto = atchFileMapper.getFileByFileSeq(fileSeq);
		Path path = Paths.get(dto.getFilePath()).resolve(dto.getSavedName());
		return new UrlResource(path.toUri());
	}

	// 파일 정보 단건 조회 (다운로드 시 원본명 헤더 세팅용)
	@Override
	public AtchFileDTO getFileInfo(Long fileSeq) {
		return atchFileMapper.getFileByFileSeq(fileSeq);
	}

	// 파일 삭제 — 실제 파일 먼저 삭제 후 DB 삭제
	@Override
	public void delete(Long fileSeq) throws Exception {
		AtchFileDTO dto = atchFileMapper.getFileByFileSeq(fileSeq);
		if (dto != null) {
			File file = new File(dto.getFilePath() + File.separator + dto.getSavedName());
			if (file.exists()) file.delete();
			atchFileMapper.deleteByFileSeq(fileSeq);
		}
	}
}
