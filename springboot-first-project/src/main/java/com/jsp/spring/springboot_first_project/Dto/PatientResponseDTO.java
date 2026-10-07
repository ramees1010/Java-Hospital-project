package com.jsp.spring.springboot_first_project.Dto;

import java.util.List;

public class PatientResponseDTO {
	

	    private Long pId;
	    private int age;
	    private String phone;
	    private String email;

	    private List<AppointmentResponseDTO> appointments;
	    private List<MedicalRecordResponseDTO> medicalRecords;

	    public Long getPId() {
	        return pId;
	    }

	    public void setPId(Long pId) {
	        this.pId = pId;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public List<AppointmentResponseDTO> getAppointments() {
	        return appointments;
	    }

	    public void setAppointments(List<AppointmentResponseDTO> appointments) {
	        this.appointments = appointments;
	    }

	    public List<MedicalRecordResponseDTO> getMedicalRecords() {
	        return medicalRecords;
	    }

	    public void setMedicalRecords(List<MedicalRecordResponseDTO> medicalRecords) {
	        this.medicalRecords = medicalRecords;
	    }
	
}
