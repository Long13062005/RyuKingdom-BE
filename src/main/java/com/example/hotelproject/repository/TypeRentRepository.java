package com.example.hotelproject.repository;

import com.example.hotelproject.entities.TypeRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRentRepository extends JpaRepository<TypeRent, Long> {
    TypeRent findByName(String name);
}
