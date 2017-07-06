package com.kovalyk.securemessages.security;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextSupport {

	public static InstantMessengerUserDetails getUserDetails() {
		return (InstantMessengerUserDetails) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}
}
