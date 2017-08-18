package com.elaine.controller;

import com.elaine.dao.DepartmentDAO;
import com.elaine.dao.impl.DepartmentDAOImpl;
import com.elaine.entity.DepartmentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")//Contoller下所有接口统一入口
public class DepartmentController {

    //映射一个action
    @RequestMapping("/department")
    @ResponseBody//表示直接输出返回内容，不进行jsp或html跳转，本例是为了写接口，这里直接返回json
    public List<DepartmentEntity> getAllDepartment() {
        //创建一个UserEntity，直接返回，之前在web.xml中配置的jackson会将user对象转为json输出
        DepartmentDAO departmentDAO=new DepartmentDAOImpl();
        return departmentDAO.getAllDepartment();
    }
}