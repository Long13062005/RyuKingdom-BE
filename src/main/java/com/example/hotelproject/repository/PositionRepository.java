package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findByName(String name);
}
