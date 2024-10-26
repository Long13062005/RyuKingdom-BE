package com.example.hotelproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Contract")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "Facility_id", nullable = false)
    private Facility facility;

    @Column(name = "date_start", nullable = false)
    private String dateStart;

    @Column(name = "date_end", nullable = false)
    private String dateEnd;

    @Column(name = "deposit", nullable = false)
    private double deposit;

    @Column(name = "history_check", nullable = false)
    private String historyCheck;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
