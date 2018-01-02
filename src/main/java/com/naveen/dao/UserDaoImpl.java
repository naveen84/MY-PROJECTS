package com.naveen.dao;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.naveen.model.User;
@Repository
public class UserDaoImpl implements UserDao
{
	@Autowired
	private HibernateTemplate ht;

	@Override
	public void saveUser(User user)
	{
		
		ht.save(user);
	}

	@Override
	public Object[] loginUser(User user) 
	{
		
		Object[] obj=null;
	    List<Object> list= (List<Object>) ht.find("select u.userName,u.userPassword from User u");
	    
	    Iterator itr = list.iterator();
	    while(itr.hasNext())
	    {
	    	 obj=(Object[])itr.next();
	    	
	    }
	    return obj;
		
	}
	
	
}
