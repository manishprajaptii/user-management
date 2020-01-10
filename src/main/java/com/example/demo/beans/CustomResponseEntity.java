package com.example.demo.beans;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CustomResponseEntity {

	
	   private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String message;
	   private Object data;
	  
	   
	   private CustomResponseEntity() {
	       timestamp = LocalDateTime.now();
	   }
	   
	   public CustomResponseEntity(HttpStatus status) {
	       this();
	       this.status = status;
	   }
	  
	   
	   public CustomResponseEntity(HttpStatus status, String message, Object data) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.data= data;
	       
	      
	   }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}




	   
	   
	   
	   
}
