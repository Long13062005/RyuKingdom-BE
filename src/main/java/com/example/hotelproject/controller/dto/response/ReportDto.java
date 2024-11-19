package com.example.hotelproject.controller.dto.response;

import com.example.hotelproject.entities.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {
    private Long id;
    private String title;

    private String description;

    private String status;

    private String date;

    private boolean deleted = false;
    private String employeeName;

}
