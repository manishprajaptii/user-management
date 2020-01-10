package com.example.demo.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.beans.MyUserDetail;
import com.example.demo.beans.UserRole;
import com.example.demo.repo.UserRepository;
import com.example.demo.repo.UserRoleRepository;


@Service
public class MyUserDetailService implements UserDetailsService{
	
    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);

@Autowired
	UserRoleRepository userRoleRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserRole> role= userRoleRepository.findByUserName(username);
		logger.info("user data been fetched..!!");
		logger.info("user data is..!", role.toString());
		return role.map(MyUserDetail::new).get();
		
	}

}
 