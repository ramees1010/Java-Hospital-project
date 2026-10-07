package com.jsp.spring.springboot_first_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.spring.springboot_first_project.entity.Department;

public interface DepartmentRepository 
		extends JpaRepository<Department, Long>{
	  Department findByDeptname(String deptName);
}
