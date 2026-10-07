package com.jsp.spring.springboot_first_project.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spring.springboot_first_project.entity.Appointment;
import com.jsp.spring.springboot_first_project.entity.Doctor;
import com.jsp.spring.springboot_first_project.entity.Patient;

public interface AppointmentRepository 
	extends JpaRepository<Appointment, Long>{
	List<Appointment> findByPatient(Patient patient);
    List<Appointment> findByDoctor(Doctor doctor);
    List<Appointment> findByAppointDateTime(LocalDateTime appointDateTime);
    List<Appointment> findByAppointStatus(Appointment.Status appointStatus);
}




