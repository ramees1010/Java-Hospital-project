package com.jsp.spring.springboot_first_project.Dto;

public class PrescriptionResponseDTO {

	    private Long prescId;
	    private String medicine;
	    private String dosage;
	    private String instruction;

	    private Long medicalRecordId;

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

	    public Long getMedicalRecordId() {
	        return medicalRecordId;
	    }

	    public void setMedicalRecordId(Long medicalRecordId) {
	        this.medicalRecordId = medicalRecordId;
	    }
	}
