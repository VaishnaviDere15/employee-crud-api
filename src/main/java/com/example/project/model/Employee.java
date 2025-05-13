package com.example.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="employees")
public class Employee
{
	
@Id

@GeneratedValue(strategy = GenerationType.IDENTITY)
private  Long id;
private  String name;
private  String email;
private String department;
private String position;

public  Employee()
{
}

public Employee(String name,String email,String department,String position)
{
	this.name=name;
	this.email=email;
	this.department=department;
	this.position=position;
}

public Long getId()
{
	return id;
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

public String getEmail()
{
	return email;
}
public void setEmail(String email)
{
	this.email=email;
}

public String getDepartment()
{
	return department;
}

public void setDepartment(String department)
{
	this.department=department;
}

public String getPosition()
{
	return position;
}
public void setPosition(String position)
{
	this.position=position;
}
}












