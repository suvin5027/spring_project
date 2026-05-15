package com.colar.spring_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colar.spring_project.dto.ReportDTO;
import com.colar.spring_project.service.ReportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

	private final ReportService reportService;

	// 신고 등록 — 중복이면 409, 성공이면 200
	@PostMapping
	public ResponseEntity<Void> report(@RequestBody ReportDTO reportDto) {
		boolean success = reportService.report(reportDto);
		if (!success) return ResponseEntity.status(409).build();
		return ResponseEntity.ok().build();
	}
}
