package com.example.hotelproject.repository;

import com.example.hotelproject.entities.TypeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCustomerRepository extends JpaRepository<TypeCustomer, Long> {
    TypeCustomer findByName(String name);
}
