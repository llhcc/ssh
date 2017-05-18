package com.llh.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.llh.ssm.dao.UserMapper;
import com.llh.ssm.domain.User;
import com.llh.ssm.service.IUserService;

@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private UserMapper userDao;  
    @Override  
    public User getUserById(int userId) {  
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);  
    }  
  
}
