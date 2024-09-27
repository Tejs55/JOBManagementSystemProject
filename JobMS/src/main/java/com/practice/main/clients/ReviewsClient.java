//package com.practice.main.clients;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.practice.main.externalCompany.Company;
//
//@FeignClient(name = "REVIEW-SERVICE")
//
//public interface ReviewsClient {
//
//	@GetMapping("/reviews")
//	List<Review> getReviews(@RequestParam Long companyId);
//	
//}
