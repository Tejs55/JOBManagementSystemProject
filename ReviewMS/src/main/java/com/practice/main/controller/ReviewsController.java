package com.practice.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.main.dto.ReviewDto;
import com.practice.main.services.ReviewServices;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

	@Autowired
	ReviewServices reviewsServices;
	
	@GetMapping("/")
	public ResponseEntity<List<ReviewDto>> getReview() {
		List<ReviewDto> getreviews = reviewsServices.readAllReviews();
		return new ResponseEntity<>(getreviews, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReviewDto> getReviewById(@PathVariable Long id ) {
		ReviewDto getAReview = reviewsServices.readReviewByID(id);
		return new ResponseEntity<>(getAReview, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<ReviewDto> postReview(@RequestBody ReviewDto entity) {
		ReviewDto  postAReview = reviewsServices.saveReview(entity);
		return new ResponseEntity<>(postAReview, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReviewDto> putReview(@PathVariable Long id, @RequestBody ReviewDto entity) {
		ReviewDto putAReview = reviewsServices.updateReview(id, entity);
		return new ResponseEntity<>(putAReview, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ReviewDto> deleteReview(@PathVariable Long id){
		ReviewDto deleteAReview = reviewsServices.deleteReview(id);
		return new ResponseEntity<>(deleteAReview, HttpStatus.OK);
	}
	
}
