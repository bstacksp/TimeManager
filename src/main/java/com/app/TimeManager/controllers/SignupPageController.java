package com.app.TimeManager.controllers;

import com.app.TimeManager.entities.dto.UserDto;
import com.app.TimeManager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/signup")
public class SignupPageController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String page() {
		return "signup";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addUser(UserDto user, HttpServletRequest request) {

		HttpSession session = request.getSession();
		userService.addUser(user);
		session.setAttribute("user", userService.getUser(user.getLogin()));
		return "redirect:/home";
	}
}
