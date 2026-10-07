package com.jsp.spring.springboot_first_project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long prescId;
	  @NotBlank
      private String medicine;
	@NotBlank
      private String dosage;
	@NotBlank
      private String instruction;
	  public Long getPrescId() {
		  return prescId;
	  }
	  public void setPrescId(Long prescId) {
		  this.prescId = prescId;
	  }
	  public String getMedicine() {
		  return medicine;
	  }
	  public void setMedicine(String medicine) {
		  this.medicine = medicine;
	  }
	  public String getDosage() {
		  return dosage;
	  }
	  public void setDosage(String dosage) {
		  this.dosage = dosage;
	  }
	  public String getInstruction() {
		  return instruction;
	  }
	  public void setInstruction(String instruction) {
		  this.instruction = instruction;
	  }
	  @OneToOne
	  @NotNull
	  public MedicalRecord medicalRecord;
      
}
