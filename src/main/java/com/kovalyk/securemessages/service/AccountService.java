package com.kovalyk.securemessages.service;

import java.util.List;

import com.kovalyk.securemessages.model.Account;

public interface AccountService extends GenericService<Account>{

	Account findAccountByEmail(String email);

	List<Account> findAccountByInfo(String info);

}
