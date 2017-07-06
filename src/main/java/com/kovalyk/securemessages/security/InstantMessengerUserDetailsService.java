package com.kovalyk.securemessages.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.service.AccountService;

public class InstantMessengerUserDetailsService implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(InstantMessengerUserDetailsService.class);
	
	@Autowired
	private AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		if (StringUtils.isBlank(username)) {
			throw new UsernameNotFoundException("Invalid username/password");
		}

		Account account = accountService.findAccountByEmail(username);

		if (account == null) {
			logger.error("Username not found");
			throw new UsernameNotFoundException("Invalid username/password");
		}
		
		logger.info(account.toString());
		
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new InstantMessengerUserDetails(account, grantedAuthorities);
	}
}
