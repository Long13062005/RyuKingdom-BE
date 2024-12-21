package com.example.hotelproject.service;

import com.example.hotelproject.controller.dto.response.ReportDto;
import com.example.hotelproject.entities.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IReportService {
    List<Report> getAllReports();
    Page<Report> findReportsByNameContainingIgnoreCase( String name, Pageable pageable);

    Report getReportById(Long id);
    Report getReportByName(String name);
     Report addReport(ReportDto reportDto);
    void softDeleteReportById(Long id);
}
