package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Employee;
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
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

        @Query(value = "SELECT * FROM Employee WHERE LOWER(name) LIKE LOWER(CONCAT('%', :name, '%')) AND deleted = false",
                nativeQuery = true)
        Page<Employee> findEmployeesByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

        Employee findByUser_Username(String username);

        Employee findByName(String name);

        @Query(value = "SELECT * FROM Employee where deleted = 0 ", nativeQuery = true)
        List<Employee> getAll();

        @Modifying
        @Transactional
        @Query(value = "UPDATE Employee e SET e.deleted = true WHERE e.id = :id", nativeQuery = true)
        void softDeleteEmployeeById(Long id);

        @Query(value = "SELECT * FROM Employee WHERE name LIKE %:search% AND deleted = 0", nativeQuery = true)
        List<Employee> searchEmployee(String search);
}
