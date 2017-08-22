package com.elaine.controller;

import com.elaine.dao.DepartmentDAO;
import com.elaine.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Transactional
@RequestMapping("/test")//Contoller下所有接口统一入口
public class DepartmentController {
    @Autowired
    private DepartmentDAO departmentDAO;
    //映射一个action
    @RequestMapping("/getDepartment")
    @ResponseBody//表示直接输出返回内容，不进行jsp或html跳转，本例是为了写接口，这里直接返回json
    public List<DepartmentEntity> getAllDepartment() {
        //创建一个UserEntity，直接返回，之前在web.xml中配置的jackson会将user对象转为json输出
        return departmentDAO.getAllDepartment();
    }
    @RequestMapping("/saveDepartment")
    @ResponseBody
    public void saveADepartment(int deptId,String deptName,String deptNo,String location){
        DepartmentEntity departmentEntity=new DepartmentEntity(deptId,deptName,deptNo,location);
        departmentDAO.saveADepartment(departmentEntity);
    }
}