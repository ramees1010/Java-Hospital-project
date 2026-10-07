package com.jsp.spring.springboot_first_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spring.springboot_first_project.entity.Department;
import com.jsp.spring.springboot_first_project.entity.Doctor;
import com.jsp.spring.springboot_first_project.entity.Patient;

public interface DoctorRepository 
        extends JpaRepository<Doctor, Long>{
	List<Doctor> findBySpecialization(String specialization);
	List<Doctor> findByavailableDays(String availableDays);
	List<Doctor> findByDepartment(Department department);
	  List<Doctor> findByAppointment_Patient(Patient patient);

	    Doctor findByAppointment_AppointId(Long appointId);
}
