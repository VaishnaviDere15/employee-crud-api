package com.example.project.service;

import com.example.project.model.Department;
import com.example.project.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService
{
	@Autowired
	private DepartmentRepository departmentrepository;
	
	public List <Department> getAllDepartments()
	{
		return departmentrepository.findAll();
	}
	
	public Department getDepartmentbyId(Long id)
	{
		return departmentrepository.findById(id).orElse(null);
		
	}
	public Department saveDepartment(Department department)
	{
		return departmentrepository.save(department);
	}
	
	public void deleteDepartment(Long id)
	{
		departmentrepository.deleteById(id);
	}
}
