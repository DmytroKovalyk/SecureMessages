package com.kovalyk.securemessages.service;

import java.util.List;

import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.model.Message;

public interface MessageService extends GenericService<Message>{
	
	List<Message> getSentMessages(Account from);
	
	List<Message> getGetMessages(Account to);
	
	List<Message> getUnreadMessages(Account to);
	
	List<Message> getFirstSixUnreadMessages(Account to);
	
	List<Message> getFirstTreeUnreadMessages(Account to);
	
	Long getCountUnreadMessages(Account to);
	
	List<Message> findByToAndFromOrderByDateAsc(Account to, Account from);
}
