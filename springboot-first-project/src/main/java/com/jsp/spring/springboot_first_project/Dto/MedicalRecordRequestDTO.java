package com.jsp.spring.springboot_first_project.Dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MedicalRecordRequestDTO {
	

	    @NotBlank
	    private String diagnosis;

	    @NotBlank
	    private String treatment;

	    @NotNull
	    private LocalDate visitDate;

	    @NotNull
	    private Long patientId;

	    @NotNull
	    private Long doctorId;

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

	    public Long getPatientId() {
	        return patientId;
	    }

	    public void setPatientId(Long patientId) {
	        this.patientId = patientId;
	    }

	    public Long getDoctorId() {
	        return doctorId;
	    }

	    public void setDoctorId(Long doctorId) {
	        this.doctorId = doctorId;
	    }
	
}
