package com.jsp.spring.springboot_first_project.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="doctor")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Long doctId;
	@Column
	@NotBlank
	private String doctorName;
	@Column
	@NotBlank
	private String specialization;
	@Column
	@NotBlank
	private String availableDays;
	
	public Long getId() {
		return doctId;
	}
	public void setId(Long doctId) {
		this.doctId = doctId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getAvailableDays() {
		return availableDays;
	}
	public void setAvailableDays(String availableDays) {
		this.availableDays = availableDays;
	}
	@ManyToOne
	@JoinColumn(name="dept_id")
	public Department department;
	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	public List<MedicalRecord> medicalrecord;
	@OneToMany(mappedBy = "doctor")
	@JsonIgnore
	public List<Appointment> appointment;
	
	
	

	
     
}
