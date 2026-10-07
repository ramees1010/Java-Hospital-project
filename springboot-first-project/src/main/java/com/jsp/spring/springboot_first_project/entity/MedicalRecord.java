package com.jsp.spring.springboot_first_project.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="medicalRecord")
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
   private Long recordId;
	@Column
	@NotNull
   private String diagnosis;
	@Column
	@NotEmpty
   private String treatment;
	@Column
	@NotNull
   private LocalDate visitDate;
   public Long getRecordId() {
	return recordId;
   }
   public void setRecordId(Long recordId) {
	this.recordId = recordId;
   }
   public String getDiagnosis() {
	return diagnosis;
   }
   public void setDiagnosis(String diagnosis) {
	this.diagnosis = diagnosis;
   }
   public String getTreatment() {
	return treatment;
   }
   public void setTreatment(String treatment) {
	this.treatment = treatment;
   }
   public LocalDate getVisitDate() {
	return visitDate;
   }
   public void setVisitDate(LocalDate visitDate) {
	this.visitDate = visitDate;
   }
   @ManyToOne
   public Patient patient;
   @ManyToOne
   public Doctor doctor;
   @OneToOne(mappedBy="medicalRecord")
   @JsonIgnore
   public Prescription prescription;
}

