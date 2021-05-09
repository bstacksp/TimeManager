package com.app.TimeManager.controllers;


import com.app.TimeManager.entities.User;
import com.app.TimeManager.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
@RequestMapping("/home")
public class HomePageController {

	@Autowired
	TimeService timeService;

	@RequestMapping(method = RequestMethod.GET)
	public String filter(Model model, HttpServletRequest request){

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		if (user == null) {
			return "redirect:/login";
		}
		model.addAttribute("time", timeService.getTime());
		return "home";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String converterPost (Model model, HttpServletRequest request) {
		if( request.getParameter("TimeStart") != null) {
			timeService.startTime();
		}
		if( request.getParameter("TimeStop") != null) {
			timeService.endTime();
		}
		if (request.getParameter("exit") != null) {
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			return "redirect:/";
		}
		return filter(model, request);
	}
}
