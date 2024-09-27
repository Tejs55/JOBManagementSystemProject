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

import com.practice.main.dto.CompanyDto;
import com.practice.main.services.CompanyServices;

@RestController
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	CompanyServices companyServices;
	
	@GetMapping("/")
	public ResponseEntity<List<CompanyDto>> getCompany() {
		List<CompanyDto> getCompany = companyServices.readAllCompanies();
		return new ResponseEntity<>(getCompany, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id) {
		CompanyDto getCompany = companyServices.readCompany(id);
		return new ResponseEntity<>(getCompany, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<CompanyDto> postCompany(@RequestBody CompanyDto entity) {
		CompanyDto postCompany = companyServices.saveCompany(entity);
		return new ResponseEntity<>(postCompany, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CompanyDto> putCompany(@PathVariable Long id, @RequestBody CompanyDto entity) {
		CompanyDto putCompany = companyServices.updateCompany(id, entity);
		return new ResponseEntity<>(putCompany, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CompanyDto> deleteCompany(@PathVariable Long id){
		CompanyDto removeCompany = companyServices.deleteCompany(id);
		return new ResponseEntity<>(removeCompany, HttpStatus.OK);
	}
	
}
