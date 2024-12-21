package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.entities.Facility;
import com.example.hotelproject.entities.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByTitle(String name);
    @Query(value = "SELECT * FROM Payment where customer_id = :id and deleted = 0", nativeQuery = true)
    List<Payment> findByCustomer(Long id);

    @Query(value = "SELECT * FROM Payment where deleted = 0 ", nativeQuery = true)
    List<Payment> getAll();

    @Query(value = "SELECT * FROM Payment WHERE LOWER(title) LIKE LOWER(CONCAT('%', :title, '%')) AND deleted = false",
            nativeQuery = true)
    Page<Payment> findPaymentsByNameContainingIgnoreCase(@Param("title") String title, Pageable pageable);


    @Modifying
    @Transactional
    @Query(value = "UPDATE Payment e SET e.deleted = true WHERE e.id = :id", nativeQuery = true)
    void softDeletePaymentById(Long id);
}
