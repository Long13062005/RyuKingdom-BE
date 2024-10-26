package com.example.hotelproject.repository;

import com.example.hotelproject.entities.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachFacilityRepository extends JpaRepository<AttachFacility, Long> {
    AttachFacility findByName(String name);
}
