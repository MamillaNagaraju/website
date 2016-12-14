package com.niit.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.UserDao;
import com.niit.model.UserDetail;
@Controller
public class HomeController
{
	@Autowired
	UserDao userdao;
	
	@RequestMapping("/")
	public ModelAndView Home()
	{
		return new ModelAndView("LandingPage");
	}
	
	@RequestMapping("/contactme")
	public ModelAndView Contact()
	{
		return new ModelAndView("ContactUs");
	}

	@RequestMapping("/login")
	public ModelAndView LoginPage()
	{
		return new ModelAndView("login");
	}
	
	@RequestMapping("/reg")
	public ModelAndView SignUp()
	{
		UserDetail userDetail=new UserDetail();
		return new ModelAndView("RegisterPage","UserDetails",userDetail);
	}

	@RequestMapping("/register")
	public ModelAndView RegisterProcess(@Valid @ModelAttribute("UserDetails") UserDetail user, BindingResult br , HttpServletRequest request)
	{

		if(br.hasErrors())
		{
			return new ModelAndView("RegisterPage");
		}
		userdao.saveorupdate(user);
		return new ModelAndView("RegisterPage");
	}
	
}


