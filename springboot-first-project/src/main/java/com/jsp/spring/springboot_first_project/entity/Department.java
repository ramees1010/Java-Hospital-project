package com.jsp.spring.springboot_first_project.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Department")
public class Department {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deptId;
     @Column
     @NotBlank
 	private String deptname;

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
	  @OneToMany(mappedBy = "department")
	  @JsonIgnore
		public List<Doctor> doctor ;
	  

}
