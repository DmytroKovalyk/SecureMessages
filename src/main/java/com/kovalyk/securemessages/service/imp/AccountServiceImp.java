package com.kovalyk.securemessages.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.repository.AccountRepository;
import com.kovalyk.securemessages.service.AccountService;

@Service("accountService")
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	@Override
	public List<Account> findAll() {
		return (List<Account>) accountRepository.findAll();
	}

	@Transactional
	@Override
	public void create(Account account) {
		accountRepository.save(account);
	}

	@Transactional
	@Override
	public void remove(Long id) {
		accountRepository.delete(id);
	}

	@Transactional
	@Override
	public Account findById(Long id) {
		return accountRepository.findOne(id);
	}

	@Override
	@Transactional
	public Account findAccountByEmail(String email) {
		return accountRepository.findAccountByEmail(email);
	}

	@Transactional
	@Override
	public List<Account> findAccountByInfo(String info) {
		info = "%" + info.toUpperCase() + "%";

		return accountRepository.findAccountByInfo(info);
	}

	@Transactional
	@Override
	public void remove(Account object) {
		accountRepository.delete(object);
	}
}
