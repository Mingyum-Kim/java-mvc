package com.techcourse.controller;

import com.interface21.context.stereotype.Controller;
import com.interface21.web.bind.annotation.RequestMapping;
import com.interface21.web.bind.annotation.RequestMethod;
import com.interface21.webmvc.servlet.ModelAndView;
import com.interface21.webmvc.servlet.view.JspView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class AnnotationRegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView save(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav = new ModelAndView(new JspView("index.jsp"));
		mav.addObject("username", "anna");
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView show(HttpServletRequest req, HttpServletResponse res) {
		return new ModelAndView(new JspView("index.jsp"));
	}
}

