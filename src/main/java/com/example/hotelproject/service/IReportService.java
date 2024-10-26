package com.example.hotelproject.service;

public interface IReportService {
    void deleteReport(Long id);
    void updateReport(Long id, String name);
    void addReport(String name);
    void getAllReports();
    void getReportById(Long id);
    void getReportByName(String name);
}
