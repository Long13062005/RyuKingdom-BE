package com.example.hotelproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "facility_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeFacility {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean deleted = false;

    public TypeFacility(String name, String description, boolean deleted) {
        this.name = name;
        this.description = description;
        this.deleted = deleted;
    }
}
