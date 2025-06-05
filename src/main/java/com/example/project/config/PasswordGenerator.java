package com.example.project.config;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordGenerator implements CommandLineRunner
{
	@Override
	public void run(String[] args)throws Exception
	{
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String rawPassword="admin123";
		String encodedPassword=encoder.encode(rawPassword);
		System.out.println("BCrypt hash for 'admin123':"+encodedPassword);
	}
}