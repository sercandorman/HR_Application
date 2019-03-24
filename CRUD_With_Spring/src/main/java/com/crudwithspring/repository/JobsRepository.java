package com.crudwithspring.repository;

import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.crudwithspring.model.Jobs;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface JobsRepository extends CrudRepository<Jobs, Long> {

	/*@Modifying
	@SQLInsert(sql = "INSERT ignore INTO jobs (id, title, description, number_of_people_to_hire, Last_Application_Date, listid) VALUES (:id, :title, :description, :number_of_people_to_hire, :Last_Application_Date, :listid);")
	@Transactional
	public void createjob(@Param("id") Long id,
			@Param("title") String title,
			@Param("description") String description,
			@Param("number_of_people_to_hire") int number_of_people_to_hire,
			@Param("Last_Application_Date") Date Last_Application_Date, @Param("listid") Long listid);*/

}
