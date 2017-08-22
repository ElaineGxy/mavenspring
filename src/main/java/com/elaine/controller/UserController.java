package com.elaine.controller;

import com.elaine.dao.DepartmentDAO;
import com.elaine.dao.UserDAO;
import com.elaine.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@Transactional
@RequestMapping("/user")//Contoller下所有接口统一入口
public class UserController {

    @Autowired
    private UserDAO userDAO;
    Map<Long,UserEntity> users=new ConcurrentHashMap<Long,UserEntity>();
    @RequestMapping(method= RequestMethod.GET)
    public String toRegister(Model model){
        model.addAttribute(new UserEntity());
        return "user_register";
    }
    public String register(Model model, UserEntity user, BindingResult result){
        if(result.hasErrors())
            return "user_register";
        return null;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginValid")
    public String login(@RequestParam("uname")String username, @RequestParam("pwd")String password){
        boolean isValid=userDAO.validateUser(username,password);
        if(isValid)
            return "main";
        return "login";
    }


}
