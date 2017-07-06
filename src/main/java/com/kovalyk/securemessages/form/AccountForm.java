package com.kovalyk.securemessages.form;

import java.io.Serializable;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class AccountForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8905296807170186750L;

	@NotEmpty(message="{validation.NotEmpty.message}")
	@Size(min=3, max=60, message="{validation.firstName.Size.message}")
	private String firstName;

	@NotEmpty(message="{validation.NotEmpty.message}")
	@Size(min=3, max=60, message="{validation.secondName.Size.message}")
	private String secondName;
	
	@NotEmpty(message="{validation.NotEmpty.message}")
	@Size(min=3, max=60, message="{validation.nickName.Size.message}")
	private String nickName;

	@Email(message="{validation.email.Email.message}")
	@NotEmpty(message="{validation.NotEmpty.message}")
	private String email;

	@Size(min=4, max=60, message="{validation.password.Size.message}")
	@NotEmpty(message="{validation.NotEmpty.message}")
	private String password;

	@Size(min=4, max=60, message="{validation.retypePassword.Size.message}")
	@NotEmpty(message="{validation.NotEmpty.message}")
	private String retypePassword;
	
	@AssertTrue(message="{validation.termsAndPolicy.AssertTrue.message}")
	private boolean termsAndPolicy;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isTermsAndPolicy() {
		return termsAndPolicy;
	}

	public void setTermsAndPolicy(boolean termsAndPolicy) {
		this.termsAndPolicy = termsAndPolicy;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
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

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

}
