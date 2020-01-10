package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.beans.UserRole;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
	Optional<UserRole> findByUserName(String userName);
}
