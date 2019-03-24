package com.crudwithspring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudwithspring.model.Applications;
import com.crudwithspring.model.Jobs;
import com.crudwithspring.repository.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;

	public Collection<Applications> findAllJobsById(Long id) {
		List<Applications> application = new ArrayList<Applications>();
		for (Applications a : applicationRepository.findAll()) {
			if (a.getJobss().getId() == id) {
				application.add(a);
			}
		}
		return application;
	}
	

	public Collection<Applications> findAllJobs() {
		List<Applications> applications= new ArrayList<Applications>();
		for (Applications app : applicationRepository.findAll()) {
			applications.add(app);
		}
		return applications;
	}

	public Applications findOne(Long id) {
		return (Applications) applicationRepository.findOne(id);
	}

	public void delete(long id) {
		applicationRepository.delete(id);
	}

	public void save(Applications applications) {
		applicationRepository.save(applications);
	}

}
