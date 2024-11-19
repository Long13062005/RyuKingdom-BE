package com.example.hotelproject.controller.dto.response;

import com.example.hotelproject.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto {
    private Long id;

    private String description;

    private int rating;

    private boolean deleted = false;
    private String  customerName;
}
