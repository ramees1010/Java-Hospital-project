package com.jsp.spring.springboot_first_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring.springboot_first_project.entity.MedicalRecord;
import com.jsp.spring.springboot_first_project.entity.Patient;
import com.jsp.spring.springboot_first_project.entity.Prescription;
import com.jsp.spring.springboot_first_project.exception.ResourceNotFoundException;
import com.jsp.spring.springboot_first_project.repository.PatientRepository;
import com.jsp.spring.springboot_first_project.repository.PrescriptionRepository;

import jakarta.validation.Valid;


@CrossOrigin(origins = "http://localhost:5173")

@RestController
	public class PrescriptionController {

	    @Autowired
	    public PatientRepository patientRepository;
	    @Autowired
	    public PrescriptionRepository prescriptionRepository;

	    @PostMapping("/prescriptions/add")
	    @ResponseStatus(code = HttpStatus.CREATED)
	    public void createPrescription(@Valid@RequestBody Prescription prescription) {
	        prescriptionRepository.save(prescription);
	    }

	    @GetMapping("/prescriptions")
	    public List<Prescription> getAllPrescriptions(
	            Authentication authentication) {

	        String email = authentication.getName();

	        Patient patient = patientRepository.findByEmail(email);

	        if (patient != null) {
	            return prescriptionRepository
	                    .findByMedicalRecord_Doctor_Appointment_Patient(patient);
	        }

	        return prescriptionRepository.findAll();
	    }

	    @GetMapping("/prescriptions/{id}")
	    public Prescription getPrescriptionById(@PathVariable Long id) {
	        return prescriptionRepository.findById(id).orElseThrow(()->
	        new ResourceNotFoundException("appointment not found with this id"+id)
	        );
	    }

	    @GetMapping("/prescriptions/medicalrecord/{recordId}")
	    public Prescription getPrescriptionByMedicalRecord(
	            @PathVariable Long recordId) {
	        MedicalRecord medicalRecord = new MedicalRecord();
	        medicalRecord.setRecordId(recordId);
	        return prescriptionRepository.findByMedicalRecord(medicalRecord);
	    }

	    @GetMapping("/prescriptions/patient/{patientId}")
	    public List<Prescription> getPrescriptionByPatient(
	            @PathVariable Long patientId) {
	        Patient patient = new Patient();
	        patient.setPId(patientId);
	        return prescriptionRepository.findByMedicalRecord_Doctor_Appointment_Patient(patient);
	    }
	}


