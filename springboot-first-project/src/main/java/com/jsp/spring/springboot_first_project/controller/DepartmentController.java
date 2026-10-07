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
import com.jsp.spring.springboot_first_project.exception.ResourceNotFoundException;
import com.jsp.spring.springboot_first_project.repository.DepartmentRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:5173")

@RestController
public class DepartmentController {
	
	@Autowired
	public DepartmentRepository departmentRepository;
	
	@GetMapping("/departments")
	public List<Department>getAllDepartments(){
		return departmentRepository.findAll();
	}
	@PostMapping("/departments/all")
	public List<Department>saveAllDepartments(@Valid@RequestBody List<Department>departments){
		 return departmentRepository.saveAll(departments);
	}
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
	return departmentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("department not found with this "+id)
		);
	
    }
	@PostMapping("/departments/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createDepartment(@Valid@RequestBody Department department) {
		 departmentRepository.save(department);
	}
	@PutMapping("/departments/update/{id}")
	public Department updateDepartment(@PathVariable Long id) {
		Department department=departmentRepository.findById(id).get();
	department.setDeptname("urology");
	departmentRepository.save(department);
	return department;
		
	}
	@DeleteMapping("/departments/delete/{id}")
	public void removeDepartment(@PathVariable Long id) {
		Department department=departmentRepository.findById(id).get();
		departmentRepository.delete(department);
	}
	@GetMapping("/departments/name/{deptname}")
	public Department getDepartmentByName(@PathVariable String deptname) {
		return departmentRepository.findByDeptname(deptname);
	}
	
}
