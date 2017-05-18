package com.llh.ssh.service.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.llh.ssh.beans.User;
import com.llh.ssh.beans.UserForm;
import com.llh.ssh.dao.BaseDao;
import com.llh.ssh.dao.impl.HibernateSessionFactory;
import com.llh.ssh.dao.impl.UserDao;
import com.llh.ssh.service.UserManager;

public class UserManagerImpl implements UserManager {  
  
	 private BaseDao dao;  
	  
	    private Session session;  
	  
	    public UserManagerImpl() {  
	        dao = new UserDao();  
	    }  
	  
	    @Override  
	    public void regUser(UserForm userForm) throws HibernateException {  
	        session = HibernateSessionFactory.currentSession();  
	        dao.setSession(session);  
	        // 获取事务  
	        Transaction ts = session.beginTransaction();  
	        // 构造User对象  
	        User user = new User();  
	        user.setUsername(userForm.getUsername());  
	        user.setPassword(userForm.getPassword());  
	        user.setGender(userForm.getGender());  
	        // 保存User对象  
	        dao.saveObject(user);  
	        // 提交事务  
	        ts.commit();  
	        // 关闭Session  
	        HibernateSessionFactory.closeSession();  
	    }  
}
