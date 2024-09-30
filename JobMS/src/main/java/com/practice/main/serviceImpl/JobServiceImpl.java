package com.practice.main.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practice.main.dto.JobDto;
import com.practice.main.external.Company;
import com.practice.main.model.Job;
import com.practice.main.repository.JobRepository;
import com.practice.main.services.JobServices;

@Service
public class JobServiceImpl implements JobServices {

	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	  public JobDto saveJob(JobDto entity) {
		Job job = modelMapper.map(entity, Job.class);
		Job saveJob = jobRepository.save(job);
		return modelMapper.map(saveJob, JobDto.class);
	}

	@Override
	public List<JobDto> readJobs() {
	 
		List<Job> job = jobRepository.findAll() ;
		List<JobDto> jobDtos = new ArrayList<JobDto>();
		for(Job jobInfo : job) {
			jobDtos.add(modelMapper.map(jobInfo, JobDto.class));
		}
		return jobDtos;
	}

	@Override
	public JobDto readJobById(Long id) {
		Job job = jobRepository.findById(id).orElseThrow();
		return modelMapper.map(job, JobDto.class);
	}

	@Override
	public JobDto updateJob(Long id, JobDto entity) {
		Job currentDetails = jobRepository.findById(id).orElseThrow();
		currentDetails.setDescription(entity.getDescription());
		currentDetails.setMinSalary(entity.getMinSalary());
		currentDetails.setMaxSalary(entity.getMaxSalary());
		currentDetails.setLocation(entity.getLocation());
		Job updatedDetails = jobRepository.save(currentDetails);
		
		return modelMapper.map(updatedDetails, JobDto.class);
	}

	@Override
	public JobDto deleteJosById(Long id) {
		Job job = this.jobRepository.findById(id).orElseThrow();
		this.jobRepository.deleteById(id);
		return null;
	}
	
}
