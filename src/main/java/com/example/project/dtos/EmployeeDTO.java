package com.example.project.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

public class EmployeeDTO
{
	
	private Long id;
	
	@NotBlank(message="Name is Mandatory")
	@Size(min=3,max=50,message="Name must be 3-50 characters")
	private String name;
	
	@NotBlank(message="Email is mandatory")
	@Email(message="Email should be valid")
	private String email;
	
	public EmployeeDTO()
	{
		
	}
	
	public EmployeeDTO(Long id,String name,String email)
	{
		this.id=id;
		this.name=name;
		this.email=email;
	}
	
	public Long getId() {
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
}
	