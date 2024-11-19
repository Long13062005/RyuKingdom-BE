package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Feedback findFeedbackByCustomer(Customer customer);

    @Query(nativeQuery = true, value = "SELECT * FROM Feedback where deleted = 0")
    List<Feedback> getAll();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Feedback f SET f.deleted = true WHERE f.id = :id")
    void softDeleteFeedbackById(Long id);
}
