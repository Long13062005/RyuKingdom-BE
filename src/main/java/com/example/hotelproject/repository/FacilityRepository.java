package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
    @Query(value = "SELECT * FROM Facility WHERE name LIKE %:search% AND deleted = 0", nativeQuery = true)

    List<Facility> findByNameContaining(String search);

    Facility findByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM facility where deleted = 0")
    List<Facility> getAll();

    @Query(value = "SELECT * FROM facility WHERE LOWER(name) LIKE LOWER(CONCAT('%', :name, '%')) AND deleted = false",
            nativeQuery = true)
    Page<Facility> findFacilitysByNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE facility f SET f.deleted = true WHERE f.id = :id")
    void softDeleteFacilityById(@Param("id") Long id);

}
