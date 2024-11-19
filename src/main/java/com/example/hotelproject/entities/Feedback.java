package com.example.hotelproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Column(nullable = false)
    private int rating;

    private boolean deleted = false;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
