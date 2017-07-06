package com.kovalyk.securemessages.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.service.AccountService;

@Component
public class SpringSecurityUserContext implements UserContext {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public Account getCurrentUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication == null) {
			return null;
		}
		String email = authentication.getName();
		if (email == null) {
			return null;
		}
		Account result = accountService.findAccountByEmail(email);
		if (result == null) {
			throw new IllegalStateException("user cannot be null");
		}
		return result;
	}

	@Override
	public void setCurrentUser(Account user) {
		if (user == null) {
			throw new IllegalArgumentException("user cannot be null");
		}
		UserDetails userDetails = userDetailsService.loadUserByUsername(user
				.getEmail());
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
				userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

}
