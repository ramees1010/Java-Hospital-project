package com.jsp.spring.springboot_first_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spring.springboot_first_project.entity.MedicalRecord;
import com.jsp.spring.springboot_first_project.entity.Patient;

public interface PatientRepository 
		extends JpaRepository<Patient, Long>{

	
	Patient findByPhone(String phone);
    Patient findByEmail(String email);
    List<Patient> findByAgeGreaterThan(Integer age);
    List<Patient> findByAppointment_AppointId(Long appointId);
     Patient findByMedicalRecord(MedicalRecord medicalRecord);




    
}
