package com.example.project.service;

import com.example.project.model.Employee;
import com.example.project.repository.EmployeeRepository;
import com.example.project.exception.EmployeeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService
{
	@Autowired
 private EmployeeRepository employeeRepository;
    public List<Employee>getAllEmployees(){
	return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));
    }

   
  public Employee addEmployee(Employee employee)
  {
  return employeeRepository.save(employee);
  }
  
  public Employee updateEmployee(Long id, Employee updatedEmployee) {
	    Employee emp = employeeRepository.findById(id)
	        .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));

	    emp.setName(updatedEmployee.getName());
	    emp.setPosition(updatedEmployee.getPosition());
	    emp.setDepartment(updatedEmployee.getDepartment());

	    return employeeRepository.save(emp);
	}

  public void deleteEmployee(Long id) {
	    if (!employeeRepository.existsById(id)) {
	    	throw new EmployeeNotFoundException("Cannot delete — employee not found with id " + id);

	    }
	    employeeRepository.deleteById(id);
  }
   public List<Employee> searchByName(String keyword)
  {
  return employeeRepository.searchByName(keyword);
 }
  public List<Employee> searchByDepartment(String department)
  {
	  return employeeRepository.searchByDepartment(department);
  }
  
  public List<Employee> getAllEmployee()
  {
	  return employeeRepository.findAll();
  }
  public List<Employee> getEmployeeByDepartment(String department)
  {
	  return employeeRepository.findByDepartment(department);
  }
  }