package com.example.hotelproject.controller.dto.response;

import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.entities.Facility;
import com.example.hotelproject.entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto {
    private Long id;

    private String payment;

    private String customerName;

    private String employeeName;

    private String facilityName;

    private String dateStart;

    private String dateEnd;

    private double deposit;

    private String historyCheck;

    private String status;

    private boolean deleted = false;
}
