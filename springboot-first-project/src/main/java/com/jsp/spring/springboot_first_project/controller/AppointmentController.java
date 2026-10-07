package com.jsp.spring.springboot_first_project.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.spring.springboot_first_project.entity.Appointment;
import com.jsp.spring.springboot_first_project.entity.Doctor;
import com.jsp.spring.springboot_first_project.entity.Patient;
import com.jsp.spring.springboot_first_project.repository.AppointmentRepository;
import com.jsp.spring.springboot_first_project.repository.PatientRepository;


@CrossOrigin(origins = "http://localhost:5173")

@RestController
public class AppointmentController{

	    @Autowired
	    public AppointmentRepository appointmentRepository;
	    @Autowired
	    public PatientRepository patientRepository;

	    @PostMapping("/appointments/add")
	    @ResponseStatus(code = HttpStatus.CREATED)
	    public void createAppointment(@RequestBody Appointment appointment) {


	            appointmentRepository.save(appointment);

	    }

	    @GetMapping("/appointments")
	    public List<Appointment> getAllAppointments() {

	        return appointmentRepository.findAll();
	    }


	    @GetMapping("/appointments/{id}")
	    public Appointment getAppointmentById(@PathVariable Long id) {
	        return appointmentRepository.findById(id).get();
	    }

	    @GetMapping("/appointments/date/{dateTime}")
	    public List<Appointment> getAppointmentByDate(@PathVariable LocalDateTime dateTime) {
	        return appointmentRepository.findByAppointDateTime(dateTime);
	    }
	    @GetMapping("/appointments/doctor/{doctorId}")
	    public List<Appointment> getAppointmentByDoctor(@PathVariable Long doctorId) {
	        Doctor doctor = new Doctor();
	        doctor.setId(doctorId);
	        return appointmentRepository.findByDoctor(doctor);
	    }
	    @GetMapping("/appointments/patient/{patientId}")
	    public List<Appointment> getAppointmentByPatient( @PathVariable Long patientId) {
	        Patient patient = new Patient();
	        patient.setPId(patientId);
	        return appointmentRepository.findByPatient(patient);
	    }
	    @GetMapping("/appointments/status/{status}")
	    public List<Appointment> getAppointmentByStatus(@PathVariable Appointment.Status status) {
	        return appointmentRepository.findByAppointStatus(status);
	    }

	    @PutMapping("/appointments/cancel/{id}")
	    public Appointment cancelAppointment(@PathVariable Long id) {

	        Appointment appointment = appointmentRepository.findById(id).get();

	        appointment.setAppointStatus(Appointment.Status.cancelled);

	        appointmentRepository.save(appointment);

	        return appointment;
	    }


	    @PutMapping("/appointments/status/{id}")
	    public  Appointment updateAppointmentStatus(
	            @PathVariable Long id,
	            @RequestBody Appointment appointment) {

	        Appointment oldAppointment =
	                appointmentRepository.findById(id).get();

	        oldAppointment.setAppointStatus(
	                appointment.getAppointStatus());

	        appointmentRepository.save(oldAppointment);

	        return oldAppointment;
	    }

}


