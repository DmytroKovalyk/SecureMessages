package com.kovalyk.securemessages.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.security.UserContext;
import com.kovalyk.securemessages.service.AccountService;
import com.kovalyk.securemessages.service.MessageService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private AccountService accountService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserContext userContext;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "redirect:/profile";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Account user = userContext.getCurrentUser();

		return "redirect:/profile/" + user.getId();
	}

	@RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
	public String userProfile(Locale locale, Model model,
			@PathVariable Long userId) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Account user = userContext.getCurrentUser();
		Account account = accountService.findById(userId);
		model.addAttribute("account", account);

		if (!user.getId().equals(account.getId())
				&& user.getFollowersToOther().contains(account)
				&& !user.getFollowersToMe().contains(account)) {
			model.addAttribute("folowingToAccount", true);
		}

		if (!user.getId().equals(account.getId())
				&& user.getFriends().contains(account)) {
			model.addAttribute("twofriends", true);
		}

		if (!user.getId().equals(account.getId())) {
			model.addAttribute("friends", account.getFirstSixFriends());
		}

		if (user.getId().equals(account.getId())) {
			model.addAttribute("messages",
					messageService.getFirstSixUnreadMessages(account));
		}

		return "profile";
	}
}
