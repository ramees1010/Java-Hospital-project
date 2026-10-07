package com.jsp.spring.springboot_first_project.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	public Long appointId;
	public Long getAppointId() {
		return appointId;
	}
	public void setAppointId(Long appointId) {
		this.appointId = appointId;
	}
	public LocalDateTime getAppointDateTime() {
		return appointDateTime;
	}
	public void setAppointDateTime(LocalDateTime appointDateTime) {
		this.appointDateTime = appointDateTime;
	}
	
	@Column
	public LocalDateTime appointDateTime;
	@Enumerated(EnumType.STRING)
	@Column
	private Status appointStatus;
	public Status getAppointStatus() {
		return appointStatus;
	}
	public void setAppointStatus(Status appointStatus) {
		this.appointStatus = appointStatus;
	}
	public enum Status{
		 Booked,
		 confirmed,
		 cancelled
	}
	@ManyToOne
	public Doctor doctor;
	@ManyToOne
	public Patient patient;
	
	
}
