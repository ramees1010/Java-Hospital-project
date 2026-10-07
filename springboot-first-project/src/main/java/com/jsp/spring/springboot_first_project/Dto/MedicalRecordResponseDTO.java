package com.jsp.spring.springboot_first_project.Dto;

import java.time.LocalDate;

public class MedicalRecordResponseDTO {
	
	    private Long recordId;
	    private String diagnosis;
	    private String treatment;
	    private LocalDate visitDate;

	    private Long patientId;
	    private Long doctorId;
	    private String doctorName;

	    private PrescriptionResponseDTO prescription;

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

	    public String getDoctorName() {
	        return doctorName;
	    }

	    public void setDoctorName(String doctorName) {
	        this.doctorName = doctorName;
	    }

	    public PrescriptionResponseDTO getPrescription() {
	        return prescription;
	    }

	    public void setPrescription(PrescriptionResponseDTO prescription) {
	        this.prescription = prescription;
	    }
	}

