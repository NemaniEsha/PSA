package com.cg.citipark.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class User {
	/*
	 * User id 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	/*
	 * First name of user
	 */
	@NotBlank(message = "First name required")
	private String firstName;
	/*
	 * Last name of user
	 */
	@NotBlank(message = "Lastname required")
	private String lastName;
	/*
	 * Email Id of user
	 */
	@NotBlank(message = "Email Id required")
	@Column(unique = true)
	private String email;
	/*
	 * Mobile number of user
	 */
	@NotBlank(message = "Mobile number required")
	@Column(nullable = false, unique = true, length = 10)
	private String mobile;
	/*
	 * Login Id of user
	 */
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "loginId", nullable = false)
	private Login login;
	
	/*
	 * Getters and Setters
	 */
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

	
}
