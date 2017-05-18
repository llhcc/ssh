package com.llh.ssh.beans;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1004683630570601328L;
	
	private Integer userId;
	
	private String username;  
	
    private String password;  
    
    private int gender;  
  
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
    public int getGender() {  
        return gender;  
    }  
  
    public void setGender(int gender) {  
        this.gender = gender;  
    }  
}
