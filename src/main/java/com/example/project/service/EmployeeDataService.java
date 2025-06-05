package com.example.project.service;

import com.example.project.dtos.EmployeeDTO;
import com.example.project.mapper.EmployeeMapper;
import com.example.project.model.Employee;
import com.example.project.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeDataService{
	private final EmployeeRepository employeeRepository;
	private final EmployeeMapper employeeMapper;
	
	public EmployeeDataService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper)
	{
		this.employeeRepository=employeeRepository;
		this.employeeMapper=employeeMapper;
	}
	
	public List<EmployeeDTO> getAllEmployees()
	{
		return employeeRepository.findAll()
				.stream()
				.map(employeeMapper::toDTO)
				.collect(Collectors.toList());
	}
	
	public EmployeeDTO addEmployee(EmployeeDTO dto)
	{
		Employee entity=employeeMapper.toEntity(dto);
		Employee saved=employeeRepository.save(entity);
		return employeeMapper.toDTO(saved);
	}
}