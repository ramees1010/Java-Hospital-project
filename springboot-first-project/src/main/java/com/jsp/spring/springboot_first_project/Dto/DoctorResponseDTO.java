package com.jsp.spring.springboot_first_project.Dto;

import java.util.List;

public class DoctorResponseDTO {

	    private Long doctId;
	    private String doctorName;
	    private String specialization;
	    private String availableDays;

	    private Long departmentId;
	    private String departmentName;

	    private List<AppointmentResponseDTO> appointments;

	    public Long getDoctId() {
	        return doctId;
	    }

	    public void setDoctId(Long doctId) {
	        this.doctId = doctId;
	    }

	    public String getDoctorName() {
	        return doctorName;
	    }

	    public void setDoctorName(String doctorName) {
	        this.doctorName = doctorName;
	    }

	    public String getSpecialization() {
	        return specialization;
	    }

	    public void setSpecialization(String specialization) {
	        this.specialization = specialization;
	    }

	    public String getAvailableDays() {
	        return availableDays;
	    }

	    public void setAvailableDays(String availableDays) {
	        this.availableDays = availableDays;
	    }

	    public Long getDepartmentId() {
	        return departmentId;
	    }

	    public void setDepartmentId(Long departmentId) {
	        this.departmentId = departmentId;
	    }

	    public String getDepartmentName() {
	        return departmentName;
	    }

	    public void setDepartmentName(String departmentName) {
	        this.departmentName = departmentName;
	    }

	    public List<AppointmentResponseDTO> getAppointments() {
	        return appointments;
	    }

	    public void setAppointments(List<AppointmentResponseDTO> appointments) {
	        this.appointments = appointments;
	    }
	
}
