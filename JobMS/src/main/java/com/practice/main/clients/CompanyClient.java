package com.practice.main.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.practice.main.external.Company;

@FeignClient(name = "CompanyService")
public interface CompanyClient { 
	@GetMapping("/companies/{id}")
	Company getCompany(@PathVariable Long id);
	
}
