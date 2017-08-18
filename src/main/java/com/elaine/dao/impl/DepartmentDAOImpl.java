package com.elaine.dao.impl;

import com.elaine.dao.DepartmentDAO;
import com.elaine.entity.DepartmentEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    public String getDepartmentById(int id) {
        return null;
    }

    public List<DepartmentEntity> getAllDepartment() {
        Session session=null;
        List<DepartmentEntity> departmentEntityList=null;
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        Configuration conf=new Configuration().configure();
        SessionFactory sessionFactory=conf.buildSessionFactory();
        session=sessionFactory.openSession();
        String hql = "From DepartmentEntity order by deptId desc";
        Query query=session.createQuery(hql);
        departmentEntityList=query.list();
        return departmentEntityList;
    }
}
