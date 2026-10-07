package com.jsp.spring.springboot_first_project.Dto;

import java.util.List;

public class DepartmentResponseDTO {
	

	    private Long deptId;
	    private String deptname;
	    private List<DoctorResponseDTO> doctors;

	    public Long getDeptId() {
	        return deptId;
	    }

	    public void setDeptId(Long deptId) {
	        this.deptId = deptId;
	    }

	    public String getDeptname() {
	        return deptname;
	    }

	    public void setDeptname(String deptname) {
	        this.deptname = deptname;
	    }

	    public List<DoctorResponseDTO> getDoctors() {
	        return doctors;
	    }

	    public void setDoctors(List<DoctorResponseDTO> doctors) {
	        this.doctors = doctors;
	    }
	
}
