package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.entities.Facility;
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
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT * FROM customer WHERE LOWER(name) LIKE LOWER(CONCAT('%', :name, '%')) AND deleted = false",
            nativeQuery = true)
    Page<Customer> findCustomersByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);
    Customer findByUser_Username(String username);

    Customer findByName(String name);

    @Query(value = "SELECT * FROM customer where deleted = 0 ", nativeQuery = true)
    List<Customer> getAll();

    @Modifying
    @Transactional
    @Query(value = "UPDATE customer e SET e.deleted = true WHERE e.id = :id", nativeQuery = true)
    void softDeleteCustomerById(Long id);

}
