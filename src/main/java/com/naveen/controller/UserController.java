package com.naveen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.naveen.dao.UserDao;
import com.naveen.model.User;

@Controller
public class UserController 
{
	//this is a second commit 
	@Autowired
	private UserDao dao;
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView saveUser(HttpServletRequest req)
	{
		
		User user = new User();
		user.setEmail(req.getParameter("email"));
		user.setUserPassword(req.getParameter("password"));
		user.setUserName(req.getParameter("userName"));
		user.setId(Integer.parseInt(req.getParameter("id")));
		dao.saveUser(user);
		return new ModelAndView("ticket","message","WELCOME TO NAVEEN SERVICES..BOOK YOUR TICKETS");
/*		if(br.hasErrors())
		{
			return new ModelAndView("ticket");
		}
		else
		{
		dao.saveUser(user);
		return new ModelAndView("ticket","message","WELCOME TO NAVEEN SERVICES..BOOK YOUR TICKETS");
		} 
		if(br.hasErrors())
		{
			return new ModelAndView("index");
		}
		else
		{
		dao.saveUser(user);
		return new ModelAndView("ticket","message","WELCOME TO NAVEEN SERVICES..BOOK YOUR TICKETS");
		} */
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
		public ModelAndView login(HttpServletRequest req)
		{
			User user = new User();
			user.setUserName(req.getParameter("uname"));
			user.setUserPassword(req.getParameter("pwd"));
			Object[] userLogin =dao.loginUser(user);
			System.out.println(userLogin[0]+"======"+userLogin[1]);
			if(userLogin[0].equals(user.getUserName()
					)&&userLogin[1].equals(user.getUserPassword()))
			{
				return new ModelAndView("ticket","message","WELCOME TO NAVEEN SERVICES..BOOK YOUR TICKETS");
			}
			else
				return new ModelAndView("index");
		}
		
	
}
