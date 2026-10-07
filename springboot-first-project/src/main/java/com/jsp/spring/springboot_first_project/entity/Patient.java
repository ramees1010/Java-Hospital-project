package com.jsp.spring.springboot_first_project.entity;

import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity

public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pId;
	@Column
	private LocalTime patientTime;
	@NotBlank
	@Size(min=10,max=10)
	private String phone;
	@Email
	@Column(unique = true)
	private String email;
	public Long getPId() {
		return pId;
	}
	public void setPId(Long pId) {
		this.pId = pId;
	}
	public LocalTime getPatientTime() {
		return patientTime;
	}
	public void setPatientTime(LocalTime patientTime) {
		this.patientTime = patientTime;
	}
	@Min(0)
	@Max(80)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	private int age;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	private enum Gender{
		male,
		female,
		others
	}
	@OneToOne(mappedBy = "patient")
	@JsonIgnore
	public MedicalRecord medicalRecord;
	@JsonIgnore
	@OneToMany(mappedBy = "patient")
	public List<Appointment> appointment;

		
}
