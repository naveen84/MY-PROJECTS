package com.naveen.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user_details")
public class User 
{
	@Id
	@Column(name="user_id")
	private int id;
	@NotEmpty(message="User name is required") @NotNull(message="User name is required")
	@Column(name="user_name")
	private String userName;
	@NotEmpty(message="Password is required") @NotNull(message="Password is required")
	@Column(name="user_password")
	private String userPassword;
	@Email(message="Invalid email format") @NotEmpty(message="Invalid email format")
	@Column(name="user_email")
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
