package com.cg.citipark.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Login {
	/*
	 * Login Id of user
	 */
	@Id
	@NotBlank(message = "Login Id required")
	private String loginId;
	/*
	 * Password of user
	 */
	@NotBlank(message = "Password required")
	private String password;
	/*
	 * Role of user
	 */
	private String role;
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "login")
	@JsonIgnore
	private User user;
	/*
	 * Getters and Setters
	 */
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
