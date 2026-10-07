package com.jsp.spring.springboot_first_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring.springboot_first_project.entity.MedicalRecord;
import com.jsp.spring.springboot_first_project.entity.Patient;
import com.jsp.spring.springboot_first_project.exception.ResourceNotFoundException;
import com.jsp.spring.springboot_first_project.repository.PatientRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")

@RestController
public class PatientController {
	 @Autowired
	    public PatientRepository patientRepository;
	
	  @PostMapping("/patients/add")
	    @ResponseStatus(code = HttpStatus.CREATED)
	    public void createPatient(@Valid@RequestBody Patient patient) {
	        patientRepository.save(patient);
	    }
	  @GetMapping("/patients/me")
	  public Patient getMyProfile(Authentication authentication) {

	      String email = authentication.getName();

	      return patientRepository.findByEmail(email);
	  }
	  @PostMapping("/patients/me")
	  @ResponseStatus(code = HttpStatus.CREATED)
	  public Patient createMyProfile(
	          @Valid @RequestBody Patient patient,
	          Authentication authentication) {

	      String email = authentication.getName();

	      patient.setEmail(email);

	      return patientRepository.save(patient);
	  }
	  @PostMapping("/patients/addall")
	    @ResponseStatus(code = HttpStatus.CREATED)
	    public List <Patient>createAllPatients(@Valid@RequestBody List<Patient> patient) {
	        return patientRepository.saveAll(patient);
	    }
	    @GetMapping("/patients")
	    public List<Patient> getAllPatients() {
	        return patientRepository.findAll();
	    }


	    @GetMapping("/patients/{id}")
	    public Patient getPatientById(@PathVariable Long id) {
	        return patientRepository.findById(id).orElseThrow(()->
	        new ResourceNotFoundException("patient not found with this id"+id)
	        );
	    }

	    @GetMapping("/patients/phone/{phone}")
	    public Patient getPatientByPhone(@PathVariable String phone) {
	        return patientRepository.findByPhone(phone);
	    }


	    @GetMapping("/patients/age/{age}")
	    public List<Patient> getPatientsAboveAge(@PathVariable int age) {
	        return patientRepository.findByAgeGreaterThan(age);
	    }
	    @GetMapping("/patients/appointments/{appointId}")
	    public List<Patient> getPatientByAppointment(@PathVariable Long appointId) {

	        return patientRepository.findByAppointment_AppointId(appointId);
	    }
	    @GetMapping("/patients/medicalrecords/{medicalRecordId}")
	    public Patient getPatientByMedicalRecord(@PathVariable Long medicalRecordId) {

	        MedicalRecord medicalRecord = new MedicalRecord();
	        // We will set the medical record ID here
	        // according to your MedicalRecord entity ID field.

	        return patientRepository.findByMedicalRecord(medicalRecord);
	    }
	    @PutMapping("/patients/update/{id}")
	    public Patient updatePatient(@PathVariable Long id) {

	        Patient patient = patientRepository.findById(id).get();

	        patient.setAge(30);

	        patientRepository.save(patient);

	        return patient;
	    }
	    @DeleteMapping("/patients/delete/{id}")
	    public void removePatient(@PathVariable Long id) {

	        Patient patient = patientRepository.findById(id).get();

	        patientRepository.delete(patient);
	    }
				
}
