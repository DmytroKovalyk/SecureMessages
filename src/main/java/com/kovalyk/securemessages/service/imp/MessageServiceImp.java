package com.kovalyk.securemessages.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.model.Message;
import com.kovalyk.securemessages.repository.MessageRepository;
import com.kovalyk.securemessages.service.MessageService;

@Service("messageService")
public class MessageServiceImp implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Transactional
	@Override
	public List<Message> findAll() {
		return (List<Message>) messageRepository.findAll();
	}

	@Transactional
	@Override
	public void create(Message object) {
		messageRepository.save(object);
	}

	@Transactional
	@Override
	public void remove(Long id) {
		messageRepository.delete(id);
	}

	@Transactional
	@Override
	public void remove(Message object) {
		messageRepository.delete(object);
	}

	@Transactional
	@Override
	public Message findById(Long id) {
		return messageRepository.findOne(id);
	}

	@Transactional
	@Override
	public List<Message> getSentMessages(Account from) {
		return messageRepository.findByFrom(from);
	}

	@Transactional
	@Override
	public List<Message> getGetMessages(Account to) {
		return messageRepository.findByTo(to);
	}

	@Transactional
	@Override
	public List<Message> getUnreadMessages(Account to) {
		return messageRepository.findByToAndRead(to, false);
	}

	@Transactional
	@Override
	public List<Message> getFirstSixUnreadMessages(Account to) {
		return messageRepository.findByToAndRead(to, false, new PageRequest(0, 6)).getContent();
	}

	@Transactional
	@Override
	public List<Message> getFirstTreeUnreadMessages(Account to) {
		return messageRepository.findByToAndRead(to, false, new PageRequest(0, 3)).getContent();
	}

	@Transactional
	@Override
	public Long getCountUnreadMessages(Account to) {
		return messageRepository.countByToAndRead(to, false);
	}

	@Override
	public List<Message> findByToAndFromOrderByDateAsc(Account to, Account from) {
		return messageRepository.findByToAndFromOrderByDateAsc(to, from);
	}

}
