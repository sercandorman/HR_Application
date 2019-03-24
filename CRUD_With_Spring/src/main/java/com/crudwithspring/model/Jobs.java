package com.crudwithspring.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity(name = "jobs")
public class Jobs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Title")
	private String title;

	@Column(name = "Description")
	private String description;

	@Column(name = "Number_Of_People_To_Hire")
	private Integer nopth;

	@Column(name = "Last_Application_Date")
	private Date lastDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="listid")
	private Lists lists;
	
	@OneToMany(mappedBy = "jobss", cascade = CascadeType.ALL)
	private List<Applications> applications;
	
	public Jobs() {}
	
	public Jobs(Long id, String title, String description, Integer nopth, Date lastDate, Lists lists) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.nopth = nopth;
		this.lastDate = lastDate;
		this.lists = lists;
	}
	
	public List<Applications> getApplications() {
		return applications;
	}

	public void setApplications(List<Applications> applications) {
		this.applications = applications;
	}

	public Lists getLists() {
		return lists;
	}

	public void setLists(Lists lists) {
		this.lists = lists;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNopth() {
		return nopth;
	}

	public void setNopth(Integer nopth) {
		this.nopth = nopth;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
}
