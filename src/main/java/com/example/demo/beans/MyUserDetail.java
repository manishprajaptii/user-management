package com.example.demo.beans;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class MyUserDetail implements UserDetails {

	private String userName;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> authorities;
	
	public MyUserDetail(UserRole userRole) {
		// TODO Auto-generated constructor stub
		this.userName = userRole.getUserName();
		this.password=userRole.getPassword();
		this.isActive= userRole.isActive();
		this.authorities=Arrays.stream(userRole.getRole().split(","))
				.map(SimpleGrantedAuthority:: new )
				.collect(Collectors.toList());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isActive;
	}

	
	
}
