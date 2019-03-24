package com.crudwithspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.crudwithspring.model.Lists;

public interface ListRepository extends CrudRepository<Lists, Long> {

}
