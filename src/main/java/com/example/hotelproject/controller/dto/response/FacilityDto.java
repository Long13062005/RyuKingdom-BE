package com.example.hotelproject.controller.dto.response;

import com.example.hotelproject.entities.TypeFacility;
import com.example.hotelproject.entities.TypeRent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacilityDto {
    private Long id;

    private String name;

    private int area;

    private double cost;

    private int maxPeople;

    private String standardRoom;

    private String description;

    private double poolArea;

    private int floor;

    private String facilityFree;

    private String rentType;

    private String facilityType;

    private boolean deleted = false;
}
