package com.practice.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.main.dto.ReviewDto;
import com.practice.main.model.Review;
import com.practice.main.repository.ReviewRepository;
import com.practice.main.services.ReviewServices;

@Service
public class ReviewServicesImpl implements ReviewServices{

	@Autowired
	ReviewRepository reviewsRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<ReviewDto> readAllReviews() {
		List<Review> review = reviewsRepository.findAll();
		List<ReviewDto> reviewDtos = new ArrayList<ReviewDto>();		
		for(Review reviewInfo : review ) {
			reviewDtos.add(modelMapper.map(reviewInfo, ReviewDto.class));
		}
		return reviewDtos;
	}

	@Override
	public ReviewDto readReviewByID(Long id) {
		Review review = reviewsRepository.findById(id).orElseThrow();
		return modelMapper.map(review, ReviewDto.class);
	}

	@Override
	public ReviewDto saveReview(ReviewDto entity) {
		Review review = modelMapper.map(entity, Review.class);
		Review saveReviewInfo = reviewsRepository.save(review);
		return modelMapper.map(saveReviewInfo, ReviewDto.class);
	}

	@Override
	public ReviewDto updateReview(Long id, ReviewDto entity) {
		Review currentDetails = reviewsRepository.findById(id).orElseThrow();
		
		currentDetails.setDescription(entity.getDescription());
		currentDetails.setRating(entity.getRating());
		currentDetails.setTitle(entity.getTitle());
		
		Review updatedReview = reviewsRepository.save(currentDetails);
		
		return modelMapper.map(updatedReview, ReviewDto.class);
	}

	@Override
	public ReviewDto deleteReview(Long id) {
		Review review = this.reviewsRepository.findById(id).orElseThrow();
		this.reviewsRepository.deleteById(id);
		return null;
	}
	
}
