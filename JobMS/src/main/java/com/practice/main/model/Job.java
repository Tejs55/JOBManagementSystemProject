package com.practice.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Job")
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "minSalary")
	private String minSalary;
	
	@Column(name = "maxSalary")
	private String maxSalary;
	
	@Column(name = "location")
	private String location;
	
	
	private Long companyId;
	
	
}
