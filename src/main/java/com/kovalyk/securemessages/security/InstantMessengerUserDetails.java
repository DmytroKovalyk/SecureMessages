package com.kovalyk.securemessages.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kovalyk.securemessages.model.Account;

public class InstantMessengerUserDetails implements UserDetails {

	private static final long serialVersionUID = -2127384289776167901L;

	private Account account;
	private List<? extends GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	public InstantMessengerUserDetails(Account account, List<? extends GrantedAuthority> authorities) {
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getEmail();
	}

	public Account getAccount() {
		return account;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
