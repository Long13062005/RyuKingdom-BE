package com.example.hotelproject.entities;

import com.example.hotelproject.security.user_auth.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "type_customer_id", nullable = false)
    private TypeCustomer typeCustomer;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String dob;
    @Column(nullable = false)
    private String idCard;
    @Column(nullable = false)
    private int gender;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String address;

    private boolean deleted = false;
}
