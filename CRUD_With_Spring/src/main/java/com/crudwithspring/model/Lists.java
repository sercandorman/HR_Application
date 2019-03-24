package com.crudwithspring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonSetter;

@Entity(name = "lists")
public class Lists implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "List_Name")
	public String listname;

	@OneToMany(mappedBy = "lists", cascade = CascadeType.ALL)
	private List<Jobs> jobs;

	public Lists() {
	}

	public Lists(Long id, String listname) {
		this.id = id;
		this.listname = listname;
	}
	
	public List<Jobs> getJobs() {
		return jobs;
	}

	public void setJobs(List<Jobs> jobs) {
		this.jobs = jobs;
	}

	public String getListName() {
		return listname;
	}

	@JsonSetter
	public void setListName(String listname) {
		this.listname = listname;
	}

	public Long getId() {
		return id;
	}

	@JsonSetter
	public void setId(Long id) {
		this.id = id;
	}

}
