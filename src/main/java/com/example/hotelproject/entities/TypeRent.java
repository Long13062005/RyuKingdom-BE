package com.example.hotelproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "rent_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeRent {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    public TypeRent(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
