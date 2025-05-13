package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 

	public class HelloController 
	{
		@GetMapping("/test")
		
			public String hello()
			{
				return "First Spring Boot Program ";
			}
			
		
      
        @GetMapping("/hello")
        
        	public Person getPerson()
        	{
        		return new Person("Vaishnavi " ,"Doe ");
        	
        	}
       
        @PostMapping("/hello")
        public ResponseEntity<String> postPerson(@RequestBody Person person) {
            String response = "Received person: " + person.getFirstname() + " " + person.getLastname();
            return ResponseEntity.ok(response);  // Ensure it's treated as a plain string response
        }

	}


