package com.llh.ssh.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.llh.ssh.dao.BaseDao;

public class UserDao implements BaseDao {  
	  
    private Session session;  
  
    @Override  
    public Session getSession() {  
        return session;  
    }  
  
    @Override  
    public void setSession(Session session) {  
        this.session = session;  
    }  
  
    @Override  
    public void saveObject(Object obj) throws HibernateException {  
        session.save(obj);  
    }  
  
}  
