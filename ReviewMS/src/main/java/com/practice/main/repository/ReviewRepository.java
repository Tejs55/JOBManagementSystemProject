package com.practice.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.main.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

	
}
