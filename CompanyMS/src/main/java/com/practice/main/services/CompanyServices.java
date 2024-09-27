package com.practice.main.services;

import java.util.List;

import com.practice.main.dto.CompanyDto;
import com.practice.main.model.Company;

public interface CompanyServices {
	
	List<CompanyDto> readAllCompanies();

	CompanyDto readCompany(Long id);

	CompanyDto saveCompany(CompanyDto entity);

	CompanyDto updateCompany(Long id, CompanyDto entity);

	CompanyDto deleteCompany(Long id);

	

	
}
