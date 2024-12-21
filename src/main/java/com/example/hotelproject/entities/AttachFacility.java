package com.example.hotelproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Attach_Facility")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private String description;


    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private int unit;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(nullable = false)
    private boolean deleted = false;

}
