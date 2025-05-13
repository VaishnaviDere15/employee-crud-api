package com.example.project.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.project.model.Employee;
import com.example.project.repository.EmployeeRepository;

@Configuration
public class LoadDatabase
{
	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository)

	{
		return args ->{
			repository.save(new Employee("Vaishnavi","vaishnavidere08@gmail.com","IT","Developer"));
			repository.save(new Employee("Pankaj","pankajbk09@gmail.com","HR","Manager"));
		};
		
	}
}

