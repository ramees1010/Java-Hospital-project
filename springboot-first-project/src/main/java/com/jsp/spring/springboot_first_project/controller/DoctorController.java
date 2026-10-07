package com.jsp.spring.springboot_first_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring.springboot_first_project.entity.Department;
import com.jsp.spring.springboot_first_project.entity.Doctor;
import com.jsp.spring.springboot_first_project.entity.Patient;
import com.jsp.spring.springboot_first_project.exception.ResourceNotFoundException;
import com.jsp.spring.springboot_first_project.repository.DoctorRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")

@RestController
public class DoctorController {
	@Autowired
	  public DoctorRepository doctorRepository;
	
   @GetMapping("/doctors")
   public List<Doctor>getAllDoctors() {
	   return doctorRepository.findAll();
   }
   @PostMapping("/doctors/add")
   @ResponseStatus(code = HttpStatus.CREATED)
   public void createDoctor(@Valid@RequestBody Doctor doctor) {
	   doctorRepository.save(doctor);
   }
   @GetMapping("/doctors/{id}")
   public Doctor getDoctorById(@PathVariable Long id) {
	    return doctorRepository.findById(id).orElseThrow(()->
        new ResourceNotFoundException("doctor not found with this id"+id)
        );
   }
   @GetMapping("/doctors/specialization/{specialization}")
   public List<Doctor> getDoctorBySpecialization(@PathVariable String specialization) {
	   return doctorRepository.findBySpecialization(specialization);  
   }
   @GetMapping("/doctors/availabledays/{availableDays}")
   public List<Doctor> getDoctorByavailableDays(@PathVariable String availableDays) {
	   return doctorRepository.findByavailableDays(availableDays);
   }
   @GetMapping("/doctors/patient/{patientId}")
   public List<Doctor> getDoctorByPatient(@PathVariable Long patientId) {
       Patient patient = new Patient();
       patient.setPId(patientId);
       return doctorRepository.findByAppointment_Patient(patient);
   }
   @PutMapping("/doctors/update/{id}")
   public Doctor updateDoctor(@PathVariable Long id) {
	   Doctor doctor=doctorRepository.findById(id).get();
	   doctor.setDoctorName("Anil");
	   doctorRepository.save(doctor);
	   return doctor;   
   }
   @DeleteMapping("/doctors/delete/{id}")
   public void removeDoctor(@PathVariable Long id){
	   Doctor doctor=doctorRepository.findById(id).get();
	   doctorRepository.delete(doctor);
   }
   @GetMapping("/doctors/departments/{deptId}")
   public List<Doctor> getDoctorsByDepartment(@PathVariable Long deptId) {

       Department department = new Department();
       department.setDeptId(deptId);

       return doctorRepository.findByDepartment(department);
   }
}
