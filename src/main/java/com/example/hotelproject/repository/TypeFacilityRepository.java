package com.example.hotelproject.repository;

import com.example.hotelproject.entities.TypeFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeFacilityRepository extends JpaRepository<TypeFacility, Long> {
    TypeFacility findByName(String name);
}
