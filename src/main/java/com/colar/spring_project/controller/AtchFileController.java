package com.colar.spring_project.controller;

import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.colar.spring_project.dto.AtchFileDTO;
import com.colar.spring_project.service.AtchFileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
public class AtchFileController {

	private final AtchFileService atchFileService;

	// 파일 업로드
	@PostMapping
	public ResponseEntity<Void> upload(
			@RequestParam Long boardSeq,
			@RequestParam List<MultipartFile> files) throws Exception {
		atchFileService.upload(boardSeq, files);
		return ResponseEntity.ok().build();
	}

	// 게시글별 파일 목록 조회
	@GetMapping("/{boardSeq}")
	public ResponseEntity<List<AtchFileDTO>> getFiles(@PathVariable Long boardSeq) {
		return ResponseEntity.ok(atchFileService.getFiles(boardSeq));
	}

	// 파일 다운로드
	@GetMapping("/download/{fileSeq}")
	public ResponseEntity<Resource> download(@PathVariable Long fileSeq) throws Exception {
		Resource resource = atchFileService.download(fileSeq);
		AtchFileDTO fileInfo = atchFileService.getFileInfo(fileSeq);
		String encodedName = URLEncoder.encode(fileInfo.getOriginalName(), StandardCharsets.UTF_8).replace("+", "%20");
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedName + "\"")
				.body(resource);
	}

	// 파일 삭제
	@DeleteMapping("/{fileSeq}")
	public ResponseEntity<Void> delete(@PathVariable Long fileSeq) throws Exception {
		atchFileService.delete(fileSeq);
		return ResponseEntity.ok().build();
	}

	// 에디터 이미지 업로드 — 저장 후 접근 URL 반환
	@PostMapping("/image")
	public ResponseEntity<Map<String, String>> uploadImage(
			@RequestParam MultipartFile image) throws Exception {
		String url = atchFileService.uploadImage(image);
		return ResponseEntity.ok(Map.of("url", url));
	}

	// 에디터 이미지 서빙 — img 태그에서 직접 접근하므로 inline으로 반환
	@GetMapping("/image/{savedName}")
	public ResponseEntity<Resource> serveImage(@PathVariable String savedName) throws Exception {
		Resource resource = atchFileService.serveImage(savedName);
		String contentType = URLConnection.guessContentTypeFromName(savedName);
		if (contentType == null) contentType = "application/octet-stream";
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_TYPE, contentType)
				.body(resource);
	}
}
