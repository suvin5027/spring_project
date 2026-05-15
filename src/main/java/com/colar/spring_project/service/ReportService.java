package com.colar.spring_project.service;

import java.util.List;

import com.colar.spring_project.dto.ReportDTO;

public interface ReportService {
	boolean report(ReportDTO reportDto);
	List<ReportDTO> getAdminReportList(ReportDTO reportDto);
	void updateStatus(ReportDTO reportDto);
}
