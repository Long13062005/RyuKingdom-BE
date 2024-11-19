package com.example.hotelproject.controller;

import com.example.hotelproject.controller.dto.response.FeedbackDto;
import com.example.hotelproject.controller.dto.response.ReportDto;
import com.example.hotelproject.service.impl.CustomerService;
import com.example.hotelproject.service.impl.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin
public class ReportController {
    @Autowired
    private ReportService reportService;



    @GetMapping()
    public ResponseEntity<?> showAllReport() {
        try {
            return new ResponseEntity<>(reportService.getAllReports(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Payments", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReport(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(reportService.getReportById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Feedback", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createReport(@RequestBody ReportDto reportDto) {
        try {

            return new ResponseEntity<>(reportService.addReport(reportDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating Feedback", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable Long id) {
        try {
            reportService.softDeleteReportById(id);
            return new ResponseEntity<>("Feedback deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting Feedback", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
