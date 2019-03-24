package com.crudwithspring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudwithspring.model.Jobs;
import com.crudwithspring.repository.JobsRepository;

@Service
public class JobsService {

	@Autowired
	private JobsRepository jobsRepository;

	public Collection<Jobs> findAllJobsById(Long id) {
		List<Jobs> jobs = new ArrayList<Jobs>();
		for (Jobs j : jobsRepository.findAll()) {
			if (j.getLists().getId() == id) {
				jobs.add(j);
			}
		}
		return jobs;
	}
	

	public Collection<Jobs> findAllJobs() {
		List<Jobs> jobs = new ArrayList<Jobs>();
		for (Jobs lst : jobsRepository.findAll()) {
			jobs.add(lst);
		}
		return jobs;
	}

	public Jobs findOne(Long id) {
		return (Jobs) jobsRepository.findOne(id);
	}

	public void delete(long id) {
		jobsRepository.delete(id);
	}

	public void save(Jobs jobs) {
		jobsRepository.save(jobs);
	}

}
