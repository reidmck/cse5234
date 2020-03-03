package edu.osu.cse5234.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

//class level request mapping to /
@RequestMapping("/")

public class Home {
	// lab 6 mappings are below
	@RequestMapping(method = RequestMethod.GET)
	public String viewHome(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "home";
	}
	
	@RequestMapping(path = "/contactUs", method = RequestMethod.GET)
	public String viewContact(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "ContactUs";
	}

	@RequestMapping(path = "/aboutUs", method = RequestMethod.GET)
	public String viewAbout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "AboutUs";
	}
}
