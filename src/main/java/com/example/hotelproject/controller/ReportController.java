package com.example.hotelproject.controller;

import com.example.hotelproject.controller.dto.response.FeedbackDto;
import com.example.hotelproject.controller.dto.response.ReportDto;
import com.example.hotelproject.entities.Facility;
import com.example.hotelproject.entities.Report;
import com.example.hotelproject.service.impl.CustomerService;
import com.example.hotelproject.service.impl.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<?> showAllReport(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "4") int size,
            @RequestParam(required = false, defaultValue = "") String name
    ) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Report> reports = reportService.findReportsByNameContainingIgnoreCase(name, pageable);

            if (reports.isEmpty()) {
                return new ResponseEntity<>("No reports found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(reports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching reports", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/all")
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
