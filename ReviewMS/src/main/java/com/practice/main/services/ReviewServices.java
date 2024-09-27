package com.practice.main.services;

import java.util.List;

import com.practice.main.dto.ReviewDto;

public interface ReviewServices {

	List<ReviewDto> readAllReviews();

	ReviewDto readReviewByID(Long id);

	ReviewDto saveReview(ReviewDto entity);

	ReviewDto updateReview(Long id, ReviewDto entity);

	ReviewDto deleteReview(Long id);

	
}
