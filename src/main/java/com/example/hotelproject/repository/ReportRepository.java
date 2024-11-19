package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM report where deleted = 0")
    List<Report> getAll();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE report r SET r.deleted = true WHERE r.id = :id")
    void softDeleteReportById(@Param("id") Long id);
}
