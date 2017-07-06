package com.kovalyk.securemessages.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.kovalyk.securemessages.form.UserId;
import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.model.Message;
import com.kovalyk.securemessages.security.UserContext;
import com.kovalyk.securemessages.service.AccountService;
import com.kovalyk.securemessages.service.MessageService;
import com.kovalyk.securemessages.util.View;

@Controller
public class MessagesController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserContext userContext;

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "my/messages", method = { RequestMethod.GET,
			RequestMethod.POST }, params = "id")
	public String messages(Locale locale, Model model,
			@RequestParam("id") Long id) {
		Account account = null;

		try {
			if (id != null) {
				account = accountService.findById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		Account user = userContext.getCurrentUser();

		if (account != null) {
			model.addAttribute("account", account);
			model.addAttribute("messages",
					messageService.findByToAndFromOrderByDateAsc(account, user));
		}

		model.addAttribute("friends", user.getFriends());

		return "messages";
	}

	@RequestMapping(value = "my/messages", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String messagesPage(Locale locale, Model model) {

		Account user = userContext.getCurrentUser();

		model.addAttribute("friends", user.getFriends());

		return "messages";
	}

	@JsonView(View.Summary.class)
	@RequestMapping(value = "my/friendmessages", method = RequestMethod.POST)
	@ResponseBody
	public List<Message> getFriendsMessages(@RequestBody UserId userId) {
		Account friend = accountService.findById(userId.getId());
		Account user = userContext.getCurrentUser();
		List<Message> list = messageService.findByToAndFromOrderByDateAsc(friend, user);

		return list;
	}
}
