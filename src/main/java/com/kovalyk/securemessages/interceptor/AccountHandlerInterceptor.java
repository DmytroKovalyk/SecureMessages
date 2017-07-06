package com.kovalyk.securemessages.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kovalyk.securemessages.form.SearchWrapper;
import com.kovalyk.securemessages.model.Account;
import com.kovalyk.securemessages.security.UserContext;
import com.kovalyk.securemessages.service.MessageService;

public class AccountHandlerInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private UserContext userContext;
	
	@Autowired
	private MessageService messageService;
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Account user = userContext.getCurrentUser();
		request.setAttribute("user", user);
		request.setAttribute("searchWrapper", new SearchWrapper());
		request.setAttribute("newMessages", messageService.getFirstTreeUnreadMessages(user));
		request.setAttribute("countNewMessages", messageService.getCountUnreadMessages(user));
		
		return super.preHandle(request, response, handler);
	}
}
