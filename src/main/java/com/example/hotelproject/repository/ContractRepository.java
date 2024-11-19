package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Contract;
import com.example.hotelproject.entities.Facility;
import com.example.hotelproject.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM contract where deleted = 0")
    List<Contract> getAll();

    @Query(value = "SELECT * FROM contract where customer_id = :id and deleted = 0", nativeQuery = true)
    List<Contract> findByCustomer(Long id);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE contract c SET c.deleted = true WHERE c.id = :id")
    void softDeleteContractById(@Param("id") Long id);
}
