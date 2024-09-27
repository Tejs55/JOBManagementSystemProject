package com.practice.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.main.dto.CompanyDto;
import com.practice.main.model.Company;
import com.practice.main.repository.CompanyRepository;
import com.practice.main.services.CompanyServices;

@Service
public  class CompanyServiceImpl  implements  CompanyServices{

	 @Autowired
	 CompanyRepository companyRepository;
	 
	 @Autowired
	 ModelMapper modelMapper;

	@Override
	public List<CompanyDto> readAllCompanies() {
		List<Company> company = companyRepository.findAll();
		List<CompanyDto> companyDtos = new ArrayList<CompanyDto>();
		for(Company companyInfo : company) {
			companyDtos.add(modelMapper.map(companyInfo, CompanyDto.class));
		}
		return companyDtos;
	}

	@Override
	public CompanyDto readCompany(Long id) {
		Company company = companyRepository.findById(id).orElseThrow();
		return modelMapper.map(company, CompanyDto.class);
	}

	@Override
	public CompanyDto saveCompany(CompanyDto entity) {
		Company company = modelMapper.map(entity, Company.class);
		Company saveCompanyInfo = companyRepository.save(company);
		return modelMapper.map(saveCompanyInfo, CompanyDto.class);
	}

	@Override
	public CompanyDto updateCompany(Long id, CompanyDto entity) {
		Company currentDetails = companyRepository.findById(id).orElseThrow();
		currentDetails.setName(entity.getName());
		currentDetails.setDescription(entity.getDescription());
		
		Company updatedDetails = companyRepository.save(currentDetails);
		return modelMapper.map(updatedDetails, CompanyDto.class);
	}

	@Override
	public CompanyDto deleteCompany(Long id) {
		Company company = this.companyRepository.findById(id).orElseThrow();
		this.companyRepository.deleteById(id);
		return null;
	}
	
}
