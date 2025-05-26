package com.example.project.controller;

import com.example.project.model.Employee;
import com.example.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")

public class EmployeeController
{
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
	this.employeeService = employeeService;
	}
	
    @GetMapping
    public List<Employee> getAllEmployees(){
    return employeeService.getAllEmployees();
    }
    
    @GetMapping("/paged")
    
    	public Page<Employee> getEmployeesPaged(
    			@PageableDefault(size = 5,sort= "id") Pageable pageable){
    	return employeeService.getAllEmployees(pageable);
    }
    
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id)
    {
    	return employeeService.getEmployeeById(id);
    }
    
    
    
    @PostMapping()
    public Employee addEmployee(@RequestBody Employee employee)
    {
    	return employeeService.addEmployee(employee);
    }
    
    @PutMapping("/{id}")
    
    	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
    	{
    		return employeeService.updateEmployee(id, employee);
    	
    	}
    
    @DeleteMapping("/{id}")
    
    	public void deleteEmployee(@PathVariable Long id)
    	{
    		 employeeService.deleteEmployee(id);
    	}
    @GetMapping("/search")
    
    	public List<Employee> searchEmployeesByName(@RequestParam String keyword){
    	 return employeeService.searchByName(keyword);
    }
    @GetMapping("by-department")
    public List<Employee> searchEmployeeByDept(@RequestParam String department)
    {
    	return employeeService.searchByDepartment(department);
    }
    
    @GetMapping("/all")
    public List <Employee> getAllEmployees1(){
    	return employeeService.getAllEmployees();
    }
    
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String department) {
        List<Employee> employees = employeeService.getEmployeeByDepartment(department);
        return ResponseEntity.ok(employees);
    }

}
 





















