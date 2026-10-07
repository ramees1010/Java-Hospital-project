package com.jsp.spring.springboot_first_project.Dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class AppointmentRequestDTO {
	

	    @NotNull
	    private LocalDateTime appointDateTime;

	    @NotNull
	    private String appointStatus;

	    @NotNull
	    private Long doctorId;

	    @NotNull
	    private Long patientId;

	    public LocalDateTime getAppointDateTime() {
	        return appointDateTime;
	    }

	    public void setAppointDateTime(LocalDateTime appointDateTime) {
	        this.appointDateTime = appointDateTime;
	    }

	    public String getAppointStatus() {
	        return appointStatus;
	    }

	    public void setAppointStatus(String appointStatus) {
	        this.appointStatus = appointStatus;
	    }

	    public Long getDoctorId() {
	        return doctorId;
	    }

	    public void setDoctorId(Long doctorId) {
	        this.doctorId = doctorId;
	    }

	    public Long getPatientId() {
	        return patientId;
	    }

	    public void setPatientId(Long patientId) {
	        this.patientId = patientId;
	    }
	
}
