package com.llh.ssh.action;

import javax.annotation.Resource;

import com.llh.ssh.beans.UserForm;
import com.llh.ssh.service.UserManager;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2121502462872634000L;

	private UserForm user;  
	@Resource  
    private UserManager userManager;  
  
    public UserForm getUser() {  
        return user;  
    }  
  
    public void setUser(UserForm user) {  
        this.user = user;  
    }  
  
    public UserManager getUserManager() {  
        return userManager;  
    }  
  
    public void setUserManager(UserManager userManager) {  
        this.userManager = userManager;  
    }  
  
    public String execute() {  
        try {  
            ///this.setUserManager(new UserManagerImpl());  
            userManager.regUser(user);  
            return SUCCESS;  
  
        } catch (Exception e) {  
            e.printStackTrace();  
            return ERROR;  
        }  
    }  
}
