package com.practice.main.services;

import java.util.List;

import com.practice.main.dto.JobDto;
import com.practice.main.model.Job;

public interface JobServices {

	JobDto saveJob(JobDto entity);

	List<JobDto> readJobs();

	JobDto readJobById(Long id);

	JobDto updateJob(Long id, JobDto entity);

	JobDto deleteJosById(Long id);

	
	
}
