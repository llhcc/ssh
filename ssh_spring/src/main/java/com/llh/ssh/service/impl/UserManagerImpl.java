package com.llh.ssh.service.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;

import com.llh.ssh.beans.User;
import com.llh.ssh.beans.UserForm;
import com.llh.ssh.dao.BaseDao;
import com.llh.ssh.dao.impl.HibernateSessionFactory;
import com.llh.ssh.dao.impl.UserDao;
import com.llh.ssh.service.UserManager;

public class UserManagerImpl implements UserManager {  
  
	private BaseDao dao;  
	  
    
    public BaseDao getDao() {
		return dao;
	}


	public void setDao(BaseDao dao) {
		this.dao = dao;
	}


	@Override  
    public void regUser(UserForm userForm) throws HibernateException {  
    	User user = new User();  
        BeanUtils.copyProperties(userForm, user);  
        dao.saveObject(user);  
    }  
}
