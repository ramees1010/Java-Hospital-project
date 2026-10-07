package com.jsp.spring.springboot_first_project.Dto;

import jakarta.validation.constraints.NotBlank;

public class DepartmentRequestDTO {

	    @NotBlank
	    private String deptname;

	    public String getDeptname() {
	        return deptname;
	    }
	    

	    public void setDeptname(String deptname) {
	        this.deptname = deptname;
	    }
	}

