package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findByName(String name);
}
