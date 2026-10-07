package com.jsp.spring.springboot_first_project.Dto;

import java.time.LocalDateTime;

public class AppointmentResponseDTO {
	

	    private Long appointId;
	    private LocalDateTime appointDateTime;
	    private String appointStatus;

	    private Long doctorId;
	    private String doctorName;

	    private Long patientId;
	    private String patientPhone;

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

	    public String getDoctorName() {
	        return doctorName;
	    }

	    public void setDoctorName(String doctorName) {
	        this.doctorName = doctorName;
	    }

	    public Long getPatientId() {
	        return patientId;
	    }

	    public void setPatientId(Long patientId) {
	        this.patientId = patientId;
	    }

	    public String getPatientPhone() {
	        return patientPhone;
	    }

	    public void setPatientPhone(String patientPhone) {
	        this.patientPhone = patientPhone;
	    }
	
}
