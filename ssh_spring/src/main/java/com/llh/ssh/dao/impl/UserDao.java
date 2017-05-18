package com.llh.ssh.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.llh.ssh.dao.BaseDao;

public class UserDao extends HibernateDaoSupport implements BaseDao {  
	  
    @Override  
    public void saveObject(Object obj) throws HibernateException {  
    	getHibernateTemplate().save(obj);  
    }  
  
}  
