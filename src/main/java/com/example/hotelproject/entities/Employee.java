package com.example.hotelproject.entities;

import com.example.hotelproject.security.user_auth.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "division_id", nullable = false)
    private Division division;

    @ManyToOne
    @JoinColumn(name = "degree_id", nullable = false)
    private Degree degree;

    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @OneToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String dob;
    @Column(nullable = false)
    private String idCard;
    @Column(nullable = false)
    private Double salary;
    @Column(nullable = false)
    private int gender;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private boolean deleted = false;
}
