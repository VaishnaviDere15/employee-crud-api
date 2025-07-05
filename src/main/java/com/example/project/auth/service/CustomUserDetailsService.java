package com.example.project.auth.service;
import com.example.project.auth.entity.User;
import com.example.project.auth.repository.UserRepository;
import com.example.project.auth.security.CustomUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user= userRepository
				.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User not found"));
		 return new CustomUserDetails(user);
		 
	}
	
}
