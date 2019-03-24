package com.crudwithspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.crudwithspring.model.Applications;

public interface ApplicationRepository extends CrudRepository<Applications, Long> {

}
