package com.jsp.spring.springboot_first_project.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DoctorRequestDTO {
	

	    @NotBlank
	    private String doctorName;

	    @NotBlank
	    private String specialization;

	    @NotBlank
	    private String availableDays;

	    @NotNull
	    private Long departmentId;

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
	
}
