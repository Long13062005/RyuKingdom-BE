package com.example.hotelproject.service.impl;

import com.example.hotelproject.controller.dto.response.ReportDto;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.entities.Report;
import com.example.hotelproject.repository.EmployeeRepository;
import com.example.hotelproject.repository.ReportRepository;
import com.example.hotelproject.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements IReportService {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Report> getAllReports() {
        return reportRepository.getAll();
    }

    @Override
    public Report getReportById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public Report getReportByName(String name) {
        return null;
    }

    @Override
    public Report addReport(ReportDto reportDto) {
        Report report = new Report();
        Employee employee = employeeRepository.findByUser_Username(reportDto.getEmployeeName());
        report.setTitle(reportDto.getTitle());
        report.setDescription(reportDto.getDescription());
        report.setStatus(reportDto.getStatus());
        report.setDate(reportDto.getDate());
        report.setDeleted(reportDto.isDeleted());
        report.setEmployee(employee);
        return reportRepository.save(report);

    }

    @Override
    public void softDeleteReportById(Long id) {
        reportRepository.softDeleteReportById(id);
    }
}
