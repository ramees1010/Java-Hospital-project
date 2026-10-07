package com.jsp.spring.springboot_first_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spring.springboot_first_project.entity.MedicalRecord;
import com.jsp.spring.springboot_first_project.entity.Patient;
import com.jsp.spring.springboot_first_project.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long>{
	
	Prescription findByMedicalRecord(MedicalRecord medicalRecord);
    List<Prescription> findByMedicalRecord_Doctor_Appointment_Patient(Patient patient);
}
