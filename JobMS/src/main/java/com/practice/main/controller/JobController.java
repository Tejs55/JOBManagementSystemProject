package com.practice.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.main.dto.JobDto;
import com.practice.main.services.JobServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	JobServices jobServices;
	
	@PostMapping("/")
	public ResponseEntity<JobDto> postJob(@RequestBody JobDto entity) {
		JobDto postJob = jobServices.saveJob(entity);
		return new ResponseEntity<>(postJob, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<JobDto>> getjobs() {
		List<JobDto> getJobs = jobServices.readJobs();
		return new ResponseEntity<>(getJobs, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<JobDto> getJobById(@PathVariable Long id) {
		JobDto getJob = jobServices.readJobById(id);
		return new ResponseEntity<>(getJob, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<JobDto> putJob(@PathVariable Long id, @RequestBody JobDto entity) {
		JobDto putJobs = jobServices.updateJob(id, entity);
		return new ResponseEntity<>(putJobs, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<JobDto>deleteJob(@PathVariable Long id){
		JobDto deletejobs = jobServices.deleteJosById(id);
		return new ResponseEntity<>(deletejobs, HttpStatus.OK);
	}
}
