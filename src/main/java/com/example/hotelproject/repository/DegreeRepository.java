package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DegreeRepository extends JpaRepository<Degree, Long> {
    Degree findByName(String name);
}
