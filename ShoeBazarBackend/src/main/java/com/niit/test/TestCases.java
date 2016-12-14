package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.ApplicationContextConfig;
import com.niit.dao.UserDao;
import com.niit.dao.UserDaoImpl;
import com.niit.model.UserDetail;

public class TestCases 
{

	static AnnotationConfigApplicationContext context;
	
	
		
		
		public TestCases()
		{
			 context= new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
			 context.scan("com.niit");
		}
		public static void main(String[] args) 
		{	
			try{
				System.out.println("main started..");
				TestCases tc = new TestCases();
				
				UserDetail user = new UserDetail();
			user.setName("rama");
			user.setUserName("niit"); 
			user.setPassword("niit@123");
			user.setEmail("ganesh@yahoo.com");
			user.setMobile("4546");
			System.out.println("done=="+user);

			//UserDao userdao = new UserDaoImpl();
			UserDao userdao = (UserDao)context.getBean("userdaoimpl");
			System.out.println("userdao="+userdao);
			userdao.saveorupdate(user);
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("main ended...");
		}

}
