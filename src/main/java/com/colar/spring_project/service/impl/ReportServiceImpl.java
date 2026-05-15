package com.colar.spring_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.colar.spring_project.dto.ReportDTO;
import com.colar.spring_project.mapper.ReportMapper;
import com.colar.spring_project.service.ReportService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

	private final ReportMapper reportMapper;

	// 신고 등록 — 중복이면 false, 성공이면 true
	@Override
	public boolean report(ReportDTO reportDto) {
		if (reportMapper.isDuplicate(reportDto) > 0) return false;
		reportMapper.insert(reportDto);
		return true;
	}

	// 신고 목록 조회 (관리자용)
	@Override
	public List<ReportDTO> getAdminReportList(ReportDTO reportDto) {
		return reportMapper.getAdminReportList(reportDto);
	}

	// 신고 처리 상태 변경
	@Override
	public void updateStatus(ReportDTO reportDto) {
		reportMapper.updateStatus(reportDto);
	}
}
