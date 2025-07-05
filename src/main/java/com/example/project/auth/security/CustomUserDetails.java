package com.example.project.auth.security;

import com.example.project.auth.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.*;

public class CustomUserDetails implements UserDetails
{
	private User user;
	
	public  CustomUserDetails(User user)
	{
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority >getAuthorities()
			{
		 String role = user.getRole();
		    if (!role.startsWith("ROLE_")) {
		        role = "ROLE_" + role;  
		    }
		return Collections.singleton(new SimpleGrantedAuthority(role));
			}
	
	@Override
	public String getPassword()
	{
	return user.getPassword();
	}
	
	@Override
	public String getUsername()
	{
		return user.getUsername();
	}
	
	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}
	
	   @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return user.isEnabled();
	    }
}