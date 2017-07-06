package com.kovalyk.securemessages.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kovalyk.securemessages.form.SearchWrapper;
import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.service.AccountService;

@Controller
public class SearchController {

	private static final String SEARCH_PAGE_TITLE = "Search Page";

	@Autowired
	private AccountService accountService;

	@ModelAttribute("searchWrapper")
	public SearchWrapper createEmployeeModel() {
		SearchWrapper searchWrapper = new SearchWrapper();
		return searchWrapper;
	}

	@RequestMapping(value = "/user/search", method = RequestMethod.POST)
	public String getResult(Locale locale, Model model,
			@ModelAttribute("searchWrapper") SearchWrapper searchWrapper) {
		model.addAttribute("titlePage", SEARCH_PAGE_TITLE);

		List<Account> accounts = accountService.findAccountByInfo(searchWrapper
				.getSearchInfo());
		model.addAttribute("accounts", accounts);

		return "search";
	}

	@RequestMapping(value = "/user/search", method = RequestMethod.GET)
	public String searchPage(Locale locale, Model model) {
		model.addAttribute("titlePage", SEARCH_PAGE_TITLE);

		List<Account> accounts = accountService.findAll();
		model.addAttribute("accounts", accounts);

		return "search";
	}
}
