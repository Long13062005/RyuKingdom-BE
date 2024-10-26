package com.example.hotelproject.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "type_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeCustomer {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public TypeCustomer(String name, boolean deleted) {
        this.name = name;
        this.deleted = deleted;
    }

    @Column(nullable = false)
    private boolean deleted = false;
}
