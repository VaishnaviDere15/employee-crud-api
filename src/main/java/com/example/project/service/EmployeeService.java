package com.example.project.service;

import com.example.project.model.Employee;
import com.example.project.projection.EmployeeBasicInfo;
import com.example.project.repository.EmployeeRepository;
import com.example.project.exception.EmployeeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
    
    public Page<EmployeeBasicInfo> getBasicEmployeeInfoPage(Pageable pageable)
    {
    	return employeeRepository.findAllBy(pageable);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));
    }

    public Employee addEmployee(Employee employee) {
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

    public List<Employee> searchByName(String keyword) {
        return employeeRepository.searchByName(keyword);
    }

   
    public List<Employee> getEmployeeByDepartment(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }
    
    public List<EmployeeBasicInfo> getAllBasicEmployeeInfo()
    {
    	return employeeRepository.findAllBy();
    }
}
