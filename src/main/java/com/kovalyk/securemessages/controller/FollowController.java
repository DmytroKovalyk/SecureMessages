package com.kovalyk.securemessages.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.security.UserContext;
import com.kovalyk.securemessages.service.AccountService;
import com.kovalyk.securemessages.util.Constants;

@Controller
public class FollowController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserContext userContext;
	
	@RequestMapping(value = "/friends/{userId}", method = RequestMethod.GET)
	public String getFriends(Locale locale, Model model,
			@PathVariable Long userId) {
		Account user = userContext.getCurrentUser();
		Account account = accountService.findById(userId);
		
		if (user.getId().equals(account.getId())){
			model.addAttribute("titlePage", Constants.MY_FRIENDS);
		} else {
			model.addAttribute("titlePage", Constants.OTHER_FRIENDS + " " + account.getFullName());
		}
		
		model.addAttribute("accounts", account.getFriends());

		return "friends";
	}
	
	@RequestMapping(value = "/following/{userId}", method = RequestMethod.GET)
	public String getFollowing(Locale locale, Model model,
			@PathVariable Long userId) {
		Account user = userContext.getCurrentUser();
		Account account = accountService.findById(userId);
		
		if (user.getId().equals(account.getId())){
			model.addAttribute("titlePage", account.getFullName() + " " + Constants.MY_FOLOWING);
		} else {
			model.addAttribute("titlePage", account.getFullName() + " " + Constants.OTHER_FOLOWING);
		}
		
		model.addAttribute("accounts", account.getFollowersToOther());

		return "following";
	}
	
	@RequestMapping(value = "/follower/{userId}", method = RequestMethod.GET)
	public String getFollower(Locale locale, Model model,
			@PathVariable Long userId) {
		Account user = userContext.getCurrentUser();
		Account account = accountService.findById(userId);
		
		if (user.getId().equals(account.getId())){
			model.addAttribute("titlePage", Constants.MY_FOLOWER);
		} else {
			model.addAttribute("titlePage", Constants.OTHER_FOLOWING + account.getFullName());
		}
		
		model.addAttribute("accounts", account.getFollowersToMe());

		return "follower";
	}
}
