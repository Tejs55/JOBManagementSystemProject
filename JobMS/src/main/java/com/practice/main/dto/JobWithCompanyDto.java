package com.practice.main.dto;

import com.practice.main.external.Company;

import lombok.Data;

@Data
public class JobWithCompanyDto {

	private Long id;
	private String title;
	private String description;
	private String minSalary;
	private String maxSalary;
	private String location;
	private Company company;
	
}
