package com.example.project.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="departments")
public class Department
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy= "department",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Employee> employees= new ArrayList<>();
	
	public Department()
	{
		
	}
	public Department(String name)
	{
		this.name=name;
	}
	public Long getId()
	{
		return this.id;
	}
	public void setId(Long id)
	{
		this.id=id;
	}
		
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	
	
	public List<Employee> getEmployees()
	{
		return employees;
	}
	public void setEmployees(List<Employee> employees)
	{
		this.employees=employees;
	}

	
	
	
	
	
	
	
	
	
	
		
	
	
}
