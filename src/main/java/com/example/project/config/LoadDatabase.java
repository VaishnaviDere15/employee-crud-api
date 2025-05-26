package com.example.project.config;

import com.example.project.model.Employee;
import com.example.project.model.Department;
import com.example.project.repository.EmployeeRepository;
import com.example.project.repository.DepartmentRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase
{
	@Bean
	CommandLineRunner initDatabase(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository)
	{
		System.out.println(">>> LoadDatabase is running...");

		return args ->
		{
			Department itdept =new Department("IT");
			Department hrdept= new Department("HR");
			Department mgmt= new Department("Management");
			Department sales=new Department("Sales");
			Department finance=new Department("Finance");
			Department marketing=new Department("Marketing");
			Department admin=new Department("Admin");
			
			departmentRepository.save(itdept);
			departmentRepository.save(hrdept);
			departmentRepository.save(sales);
			departmentRepository.save(finance);
			departmentRepository.save(marketing);
			departmentRepository.save(admin);
			
			
			employeeRepository.save(new Employee("Vaishnavi Dere", "vaishnavidere@tcs.com", itdept, "Developer"));
			System.out.println(">>> Inserted Vaishnavi");

			employeeRepository.save(new Employee ("Ravi Shankar","r.shankar@tcs.com", finance ,"Account Manager"));
			employeeRepository.save(new Employee ("Neha Dubey","nehadubey@tcs.com", itdept ,"tester"));
			employeeRepository.save(new Employee ("Divya Sharma","divya.sharma@tcs.com", itdept, "Developer"));
			employeeRepository.save(new Employee ("Aman Tiwari","tiwari.aman@tcs.com", sales ,"Business Development"));
			employeeRepository.save(new Employee ("Nikhil Bansal","nikhil.bansal@tcs.com", admin ,"Office Administrator"));
			employeeRepository.save(new Employee ("Sneha Reddy","snehareddy@tcs.com", itdept ,"FrontEnd Developer"));
			employeeRepository.save(new Employee ("Karan Mehta","mehta.karan@tcs.com", finance, "Financial Analyst"));
			employeeRepository.save(new Employee ("Vaishnavi Desai","vaishnavidesai@tcs.com", itdept, "Backend Developer"));
			employeeRepository.save(new Employee ("Rohit Sharma","rs.sharma@tcs.com", sales ,"Sales Executive"));
			employeeRepository.save(new Employee ("Tanu Bhardwaj","tanubhardwaj@tcs.com", itdept ,"Analyst"));
			employeeRepository.save(new Employee ("Supriya Pawar","Supriyapawar@tcs.com", itdept ,"Software Developer"));
			employeeRepository.save(new Employee ("Rohan Ugale","rohanugale@tcs.com", marketing ,"Content strategist"));
			employeeRepository.save(new Employee ("Geetansh Agrawal","geetansh.agr@tcs.com", admin ,"Office Administrator"));
			employeeRepository.save(new Employee ("Pooja Gupta","poojagupta@tcs.com", marketing ,"Digital Marketing"));
			
			
			
			
			
		};
		
		
	
}
}
