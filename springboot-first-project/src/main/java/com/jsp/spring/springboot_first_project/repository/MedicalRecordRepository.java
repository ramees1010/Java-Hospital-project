package com.jsp.spring.springboot_first_project.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spring.springboot_first_project.entity.Appointment;
import com.jsp.spring.springboot_first_project.entity.Doctor;
import com.jsp.spring.springboot_first_project.entity.MedicalRecord;
import com.jsp.spring.springboot_first_project.entity.Patient;

public interface MedicalRecordRepository 
		extends JpaRepository<MedicalRecord, Long>{

        List<MedicalRecord> findByDoctor(Doctor doctor);
	    List<MedicalRecord> findByVisitDate(LocalDate visitDate);
	    List<MedicalRecord> findByDoctor_Appointment_Patient(Patient patient);
	    List<MedicalRecord> findByDoctor_Appointment(Appointment appointment);
	
}
