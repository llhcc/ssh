package com.llh.ssh.dao.impl;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static final String CFG_FILE_LOCATION = "/Hibernate.cfg.xml";  
	  
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();  
  
    private static final Configuration cfg = new Configuration()  
            .configure(CFG_FILE_LOCATION);  
  
    /*private static ServiceRegistryBuilder builder = new ServiceRegistryBuilder()  
            .applySettings(cfg.getProperties());  
  
    private static ServiceRegistry registry;  */
  
    private static SessionFactory sessionFactory;  
  
    public static Session currentSession() throws HibernateException {  
        Session session = threadLocal.get();  
  
        if (session == null || session.isOpen() == false) {  
  
            if (sessionFactory == null) {  
               /* try {  
                    registry = builder.buildServiceRegistry();  
                    sessionFactory = cfg.buildSessionFactory(registry);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                }  */
            	/**
            	 * Hibernate 3.x没有ServiceRegistry，就是简单的去掉即可，而且，Hibernate.cfg.xml在classpath路径下默认名字，也可以不用写入参数。
            	 */
            	try {                     
                    sessionFactory = cfg.buildSessionFactory();                  
                } catch (Exception e) {                      
                    e.printStackTrace();                  
                }  
            }  
  
            session = sessionFactory.openSession();  
            threadLocal.set(session);  
  
        }  
  
        return session;  
    }  
  
    public static void closeSession() throws HibernateException {  
        Session session = threadLocal.get();  
        threadLocal.set(null);  
        if (session != null) {  
            session.close();  
        }  
    }  
  
}
