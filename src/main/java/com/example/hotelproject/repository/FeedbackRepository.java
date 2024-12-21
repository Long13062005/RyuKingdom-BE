package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Feedback;
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
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query(value = "SELECT * FROM Feedback WHERE deleted = false",
            nativeQuery = true)
    Page<Feedback> findFeedbacksByNameContainingIgnoreCase(Pageable pageable);


    @Query(nativeQuery = true, value = "SELECT * FROM Feedback where deleted = 0")
    List<Feedback> getAll();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Feedback f SET f.deleted = true WHERE f.id = :id")
    void softDeleteFeedbackById(Long id);


}
