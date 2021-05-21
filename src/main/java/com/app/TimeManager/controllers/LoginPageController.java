package com.app.TimeManager.controllers;

import com.app.TimeManager.entities.dto.UserDto;
import com.app.TimeManager.services.TimeService;
import com.app.TimeManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/login")
public class LoginPageController {

	@Autowired
	UserService userService;

	@Autowired
	TimeService timeService;

	@RequestMapping( method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String postLogin(User user, HttpServletRequest request) {
		if (!(userService.login(user.getLogin(), user.getPassword()))) {
			return "login";
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", userService.getUser(user.getLogin()));
		timeService.startTime(user);
		return "redirect:/home";
	}
}