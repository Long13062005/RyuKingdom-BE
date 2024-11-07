package com.example.hotelproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "position")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "name", nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean deleted = false;

    public Position(String name, boolean deleted) {
        this.name = name;
        this.deleted = deleted;
    }
}
