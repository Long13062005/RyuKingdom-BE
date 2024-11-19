package com.example.hotelproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Report")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private boolean deleted = false;
    @ManyToOne
    @JoinColumn(name = "Employee_id", nullable = false)
    private Employee employee;


}
