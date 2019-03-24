package com.crudwithspring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crudwithspring.model.Lists;
import com.crudwithspring.repository.ListRepository;

@Service
public class ListsService {

	@Autowired
	private ListRepository listRepository;

	public Collection<Lists> findAllLists() {
		List<Lists> lists = new ArrayList<Lists>();
		for (Lists lst : listRepository.findAll()) {
			lists.add(lst);
		}
		return lists;
	}

	public Lists findOne(Long id) {
		return (Lists) listRepository.findOne(id);
	}

	public void delete(long id) {
		listRepository.delete(id);
	}

	public void save(Lists lists) {
		listRepository.save(lists);
	}

}
