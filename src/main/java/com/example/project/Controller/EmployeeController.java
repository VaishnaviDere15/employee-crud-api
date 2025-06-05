package com.example.project.controller;

import com.example.project.dtos.EmployeeDTO;
import com.example.project.model.Employee;
import com.example.project.projection.EmployeeBasicInfo;
import com.example.project.service.EmployeeDataService;
import com.example.project.service.EmployeeService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeDataService employeeDataService;

    public EmployeeController(EmployeeService employeeService, EmployeeDataService employeeDataService) {
        this.employeeService = employeeService;
        this.employeeDataService = employeeDataService;
    }

   
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

   
    @GetMapping("/dto")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployeeDTOs() {
        return ResponseEntity.ok(employeeDataService.getAllEmployees());
    }

   
    @GetMapping("/paged")
    public ResponseEntity<Page<Employee>> getEmployeesPaged(
            @PageableDefault(size = 5, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(employeeService.getAllEmployees(pageable));
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

 
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @PostMapping("/dto")
    public ResponseEntity<EmployeeDTO> addEmployeeDTO(@Valid @RequestBody EmployeeDTO employeedto)
    {
    	EmployeeDTO saved=employeeDataService.addEmployee(employeedto);
    	return ResponseEntity.ok(saved);
    	
    }
   
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

   
    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployeesByName(@RequestParam String keyword) {
        return ResponseEntity.ok(employeeService.searchByName(keyword));
    }

 
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(employeeService.getEmployeeByDepartment(department));
    }
    
    @GetMapping("/basic-info")
    public ResponseEntity<List<EmployeeBasicInfo>> getBasicEmployeeInfo()
    {
        return  ResponseEntity.ok(employeeService.getAllBasicEmployeeInfo());
    }

    
   @GetMapping("/basic-info-paged")
   public ResponseEntity<Page<EmployeeBasicInfo>> getBasicEmployeeInfoPaged(
		   @RequestParam(defaultValue="0") int page,
		   @RequestParam(defaultValue="5") int size)
   {
	   Pageable pageable =PageRequest.of(page,size);
	   Page<EmployeeBasicInfo> pageResult= employeeService.getBasicEmployeeInfoPage(pageable);
	   return ResponseEntity.ok(pageResult);
   }
		   
    
	    
   
    
}
