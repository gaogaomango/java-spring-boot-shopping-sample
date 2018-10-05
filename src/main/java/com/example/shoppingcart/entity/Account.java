package com.example.shoppingcart.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Accounts")
@Setter
@Getter
public class Account implements Serializable {

	public static final String ROLE_MANAGER = "MANAGER";
	public static final String ROLE_EMPLOYEE = "EMPLOYEE";
	
	@Id
	@Column(name = "User_Name", length = 20, nullable = false)
	private String userName;
	
	@Column(name = "Encryted_Password", length = 128, nullable = false)
	private String encrytedPassword;
	
	@Column(name = "Active", length = 1, nullable = false)
	private boolean active;
	
	@Column(name = "User_Role", length = 20, nullable = false)
	private String userRole;
	
	@Override
	public String toString() {
		return "[" + this.userName + "," + this.encrytedPassword + "," + this.userRole + "]";
	}
}
