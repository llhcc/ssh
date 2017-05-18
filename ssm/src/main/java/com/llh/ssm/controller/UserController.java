package com.llh.ssm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.llh.ssm.domain.User;
import com.llh.ssm.service.IUserService;

@Controller  
@RequestMapping("/user")  
public class UserController extends BaseAction{  
    @Resource  
    private IUserService userService;  
      
    @RequestMapping("/showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.userService.getUserById(userId);  
        model.addAttribute("user", user);  
        //model.addAttribute("ss", this.ss);
        return "showUser";  
    }  
}  