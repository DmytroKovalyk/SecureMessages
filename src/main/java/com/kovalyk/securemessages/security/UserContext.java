package com.kovalyk.securemessages.security;

import com.kovalyk.securemessages.model.Account;

public interface UserContext {

	Account getCurrentUser();

	void setCurrentUser(Account user);
}
