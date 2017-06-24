package com.telusko.dao;



import org.springframework.stereotype.Repository;

import com.telusko.entity.Feedback;

@Repository("Feed")
public class FeedbackDao {
	
	
	public void addFeedback(Feedback feedback) 
	{
	
		System.out.println("I m in feedback" +feedback);
	}

}
