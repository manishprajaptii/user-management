package com.example.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	@JsonProperty("first_name")
	@NotBlank(message="Name should not blank/null")
	private String firstName;
	
	@JsonProperty("last_name")
	@NotBlank(message="last Name should not be blank")
	private String lastName;
	
	private String address;
	
	
	//private String fullName;
	private int age;
	private String technology;
	
	//@NotBlank(message="mobile Number should not be blank")
	private int mobileNumber;
	
	
	/*
	 * public User() {
	 * 
	 * 
	 * }
	 */
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", age=" + age + ", technology=" + technology + ", mobileNumber=" + mobileNumber + "]";
	}
	
	
}
