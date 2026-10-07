package com.jsp.spring.springboot_first_project.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PrescriptionRequestDTO {

	    @NotBlank
	    private String medicine;

	    @NotBlank
	    private String dosage;

	    @NotBlank
	    private String instruction;

	    @NotNull
	    private Long medicalRecordId;

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

	    public Long getMedicalRecordId() {
	        return medicalRecordId;
	    }

	    public void setMedicalRecordId(Long medicalRecordId) {
	        this.medicalRecordId = medicalRecordId;
	    }
	
}
