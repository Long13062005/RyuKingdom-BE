package com.example.hotelproject.controller.dto.response;

import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.entities.Facility;
import com.example.hotelproject.entities.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long id;
    private String title;
    private Double deposit;
    private String historyDate;
    private String status;
    private String employeeName;
    private String customerName;
    private boolean deleted = false;
}
