package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface DivisionRepository extends JpaRepository<Division, Long> {
    Division findByName(String name);
}
