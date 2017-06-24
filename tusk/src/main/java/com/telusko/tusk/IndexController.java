package com.telusko.tusk;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.telusko.dao.FeedbackDao;
import com.telusko.entity.Feedback;


@Controller
public class IndexController {

//@Autowired
FeedbackDao Feed;

	
	
	@RequestMapping("/")
	public String home()
	{
	
		return "index.jsp";
	}
 
	
      @RequestMapping("/huh")
	public String feedback(){
		return "redirect :feedback";
		
	}
	
	
	@RequestMapping("/rapap")
	 	public String addFeedback(@ModelAttribute("feedback") Feedback feedback)
		{
		System.out.println("I am in add method");
		feedback = new Feedback();

	
			Feed.addFeedback(feedback);
			return "redirect:/welcome";
		
		}

}
