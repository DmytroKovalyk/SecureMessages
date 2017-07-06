package com.kovalyk.securemessages.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kovalyk.securemessages.form.AccountForm;
import com.kovalyk.securemessages.form.Notification;
import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.security.UserContext;
import com.kovalyk.securemessages.service.AccountService;

@Controller
public class AuthorizationController {

	private static final Logger logger = LoggerFactory
			.getLogger(AuthorizationController.class);

	@Autowired
	private AccountService accountService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	private UserContext userContext;
	
	@Autowired
	PasswordEncoder encoder;

	@ModelAttribute("account")
	public AccountForm createEmployeeModel() {
		logger.info("Create empty modelAttribute account.");
		AccountForm account = new AccountForm();
		return account;
	}

	@RequestMapping(value = "/authorization", method = RequestMethod.GET)
	public String getPage(Model model) {
		return "authorization";
	}

	@RequestMapping(value = "/authorization", method = RequestMethod.POST)
	public String authorizate(
			@ModelAttribute("account") @Validated AccountForm account,
			BindingResult bindingResult, Model model, Locale locale) {
		if (accountService.findAccountByEmail(account.getEmail()) != null) {
			bindingResult
					.rejectValue("email", "validation.email.Exist.message");
		}
		if (!account.getPassword().equals(account.getRetypePassword())) {
			bindingResult.rejectValue("retypePassword",
					"validation.retypePassword.Different.message");
		}
		if (bindingResult.hasErrors()) {
			model.addAttribute(
					"message",
					new Notification("danger", messageSource.getMessage(
							"user.create.fail", new Object[] {}, locale)));
			return "authorization";
		}

		Account user = getAccountFromAccountForm(account);

		String encodedPassword = encoder.encode(user.getPassword());

		user.setPassword(encodedPassword);

		accountService.create(user);

		userContext.setCurrentUser(user);

		model.addAttribute(
				"message",
				new Notification("success", messageSource.getMessage(
						"user.create.success", new Object[] {}, locale)));

		return "redirect:/index";
	}

	private Account getAccountFromAccountForm(AccountForm account) {
		Account user = new Account();
		user.setFirstName(account.getFirstName());
		user.setSecondName(account.getSecondName());
		user.setNickName(account.getNickName());
		user.setPassword(account.getPassword());
		user.setEmail(account.getEmail());

		return user;
	}
}
