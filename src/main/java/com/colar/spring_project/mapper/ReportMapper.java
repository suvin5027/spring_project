package com.colar.spring_project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.colar.spring_project.dto.ReportDTO;

@Mapper
public interface ReportMapper {
	// 신고 등록
	int insert(ReportDTO reportDto);
	// 중복 신고 여부 조회 (같은 유저가 같은 대상 이미 신고했으면 1)
	int isDuplicate(ReportDTO reportDto);
	// 신고 목록 조회 (관리자용)
	List<ReportDTO> getAdminReportList(ReportDTO reportDto);
	// 신고 처리 상태 변경
	int updateStatus(ReportDTO reportDto);
}
