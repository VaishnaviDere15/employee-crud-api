package com.example.project.config;

import com.example.project.auth.entity.User;
import com.example.project.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer
{
	@Bean
	public CommandLineRunner createDefaultadmin(UserRepository userRepository, PasswordEncoder passwordEncoder)
	{
		return args->
		{
			if(!userRepository.existsByUsername("admin"))
			
			{
				User admin=new User();
				admin.setUsername("admin");
				admin.setPassword(passwordEncoder.encode("admin123"));
				admin.setEnabled(true);
				admin.setRole("ROLE_ADMIN");
				userRepository.save(admin);
				System.out.println("Default admin created");
				
			
			}
			else
			{
				 System.out.println("ℹ️ Admin user already exists.");
			}
			
			 if (!userRepository.existsByUsername("user")) {
		            User user = new User();
		            user.setUsername("user");
		            user.setPassword(passwordEncoder.encode("user123"));
		            user.setEnabled(true);
		            user.setRole("ROLE_USER");
		            userRepository.save(user);
		            System.out.println("✅ Normal user created");
		        }
			else
			{
				 System.out.println("ℹ️  user already exists.");
			}
		};
	}
}
	
	
