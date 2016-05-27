package com.register.action;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.register.model.User;


public class LoginActionTest {

	@Test
	public void testList() throws Exception{
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		LoginAction loginAction=(LoginAction)ac.getBean("registerAction");
		loginAction.list();
		List<User> res=loginAction.getUsers();
		for(User u:res){
			System.out.println(u.getUsername()+"  "+u.getPassword());
		}
		Assert.assertTrue(loginAction.getUsers().size()>0);
	}
	

}
