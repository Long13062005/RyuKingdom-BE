package com.example.hotelproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Facility")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facility {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int area;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private int maxPeople;

    @Column(name = "standard_room", nullable = false)
    private String standardRoom;

    @Column(nullable = false)
    private String description;

    @Column(name = "pool_area")
    private double poolArea;

    @Column(name = "number_of_floors")
    private int numberOfFloors;

    @Column(name = "facility_free")
    private String facilityFree;

    @ManyToOne
    @JoinColumn(name = "rent_type_id", nullable = false)
    private TypeRent typeRent;

    @ManyToOne
    @JoinColumn(name = "facility_type_id", nullable = false)
    private TypeFacility typeFacility;

    @Column(nullable = false)
    private boolean deleted = false;
}
