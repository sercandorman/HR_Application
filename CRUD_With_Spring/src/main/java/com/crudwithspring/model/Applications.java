package com.crudwithspring.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.mysql.jdbc.Blob;

@Entity(name = "applications")
public class Applications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "EMail")
	private String email;

	@Column(name = "Phone")
	private Integer phone;

	@Column(name = "Address")
	private String address;

	@Column(name = "Thoughts_On_Job")
	private String thoughts_on_job;

	@Lob
	@Column(name = "Resume")
	private byte[] resume;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Job_ID")
	private Jobs jobss;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getThoughts_on_job() {
		return thoughts_on_job;
	}

	public void setThoughts_on_job(String thoughts_on_job) {
		this.thoughts_on_job = thoughts_on_job;
	}

	public byte[] getResume() {
		return resume;
	}

	public void setResume(byte[] resume) {
		this.resume = resume;
	}

	public Jobs getJobss() {
		return jobss;
	}

	public void setJobss(Jobs jobss) {
		this.jobss = jobss;
	}

}
