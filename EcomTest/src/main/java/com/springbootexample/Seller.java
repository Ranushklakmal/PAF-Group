package com.springbootexample;

import java.io.Serializable;

import javax.persistence.Entity; 
import javax.persistence.EntityListeners; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType; 
import javax.persistence.Id; 
import javax.persistence.Table; 
import org.springframework.data.jpa.domain.support.AuditingEntityListener; 

@Entity @Table(name="Employees") @EntityListeners(AuditingEntityListener.class) public class Seller  implements Serializable{ 
	 
	 private static final long serialVersionUID = 1143993377101043360L; 
	 
	 @Id  
	 @GeneratedValue(strategy=GenerationType.AUTO)  
	 private Long id;  
	 private String name;  
	 private String designation;  
	private String email;
	 private String phone;
	 
	
	 public String getName() {   
		 return name;  
		 }  
	 public void setName(String name) {   
		 this.name = name;  
		 }  
	 public String getDesignation() {   
		 return designation;  }  
	 public void setDesignation(String designation) {   
		 this.designation = designation;  
		 }  
	 public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
	 public Long getId() {   
			 return id;  
		 }  
	 public void setId(Long id) {   
		 this.id = id;  } 
	 } 




