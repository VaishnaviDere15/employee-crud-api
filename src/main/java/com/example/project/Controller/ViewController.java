package com.example.project.controller;

import com.example.project.model.Employee;
import com.example.project.service.EmployeeService;
import com.example.project.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/view/employees")
public class ViewController
{
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService; 
 
	@GetMapping()
	public String listEmployees(@RequestParam(defaultValue ="0") int page,
	                           @RequestParam(defaultValue ="10")int size , Model model)
	
	{
		Page<Employee> employeePage= employeeService.getAllEmployees(PageRequest.of(page, size,Sort.by("id").ascending()));
		model.addAttribute("employeePage",employeePage);
		model.addAttribute("currentPage",page);
		model.addAttribute("totalPages",employeePage.getTotalPages());
		model.addAttribute("size",size);
		
		return "employees/list";
		
	}
	
	@GetMapping("/add")
	public String showAddEmployeeForm(Model model)
	{
		model.addAttribute("employee", new Employee());
		model.addAttribute("departments", departmentService.getAllDepartments());
		return "employees/create";
		
	}
	
	@PostMapping("/add")
	
		public String saveEmployee(@ModelAttribute Employee employee)
		{
			employeeService.addEmployee(employee);
			return "redirect:/view/employees";
			
		}
	@GetMapping("/edit/{id}")
	
    public String showEditEmployeeForm(@PathVariable Long id, Model model)
    {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		model.addAttribute("departments",departmentService.getAllDepartments());
		return "employees/edit";
		
    }
	
	@PostMapping("/edit/{id}")
	
		public String updateEmployee(@PathVariable Long id,@ModelAttribute Employee employee)
		{
		employeeService.updateEmployee(id,employee);
		return "redirect:/view/employees";
		}
	@GetMapping("/delete/{id}")
	
	 public String deleteEmployee(@PathVariable Long id)
	 {
		employeeService.deleteEmployee(id);
		return "redirect:/view/employees";
	 }
	
}
	
		
	
	
	
	
	
	




