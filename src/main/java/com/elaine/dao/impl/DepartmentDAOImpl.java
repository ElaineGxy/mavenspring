package com.elaine.dao.impl;

import com.elaine.dao.DepartmentDAO;
import com.elaine.entity.DepartmentEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class DepartmentDAOImpl implements DepartmentDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    public String getDepartmentById(int id) {
        return null;
    }

    @Transactional
    public List<DepartmentEntity> getAllDepartment() {
        List<DepartmentEntity> departmentEntityList;
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件

        String hql = "From DepartmentEntity order by deptId desc";
        Query query=getSession().createQuery(hql);
        departmentEntityList=query.list();
        return departmentEntityList;
    }
    public void saveADepartment(DepartmentEntity department){
        getSession().save(department);
    }
}
