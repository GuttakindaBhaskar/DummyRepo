package com.example.demo.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "First name is mandatory")
	@NotBlank(message = "First name is mandatory")
	@Pattern(regexp = "\\S+",message = "First name must not contains white spaces")
	private String firstname;
	
	@NotEmpty(message = "Last name is mandatory")
	@NotBlank(message = "Last name is mandatory")
	@Pattern(regexp = "\\S+",message = "Last name must not contains white spaces")
	private String lastname;
	
	@NotEmpty(message = "Email is mandatory")
	@NotBlank(message = "Email is mandatory")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Email address is invalid(White spaces not allowed)")
	private String email;
	
	@NotEmpty(message = "Password is mandatory")
	@NotBlank(message = "Password is mandatory")
    @Size(min = 8, max = 25)
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message = "Password atleast one uppercase, one lowercase, one number and one special character(White spaces not allowed)")
	private String password;
	
	@NotEmpty(message = "Country is mandatory")
	@NotBlank(message = "Country is mandatory")
	private String country;
	
	@NotEmpty(message = "Phone Number is mandatory")
	@NotBlank(message = "Phone Number is mandatory")
	private String phone;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password
				+ ", country=" + country + ", phone=" + phone + "]";
	}


}
