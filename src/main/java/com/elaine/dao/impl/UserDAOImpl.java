package com.elaine.dao.impl;

import com.elaine.entity.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class UserDAOImpl implements com.elaine.dao.UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //获取和当前线程绑定的Seesion
    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    public UserEntity login(String username, String password) {
        String hql="FROM UserEntity WHERE userName=: name AND userPwd=:pwd";
        Query query=getSession().createQuery(hql);
        query.setParameter("name",username);
        query.setParameter("pwd",password);
        List<UserEntity> userList=query.list();
        if(userList!=null && userList.size()==1)return userList.get(0);
        return null;
    }

    public Integer save(UserEntity user) {
        return (Integer) this.getSession().save(user);
    }

    public void update(UserEntity user) {
        this.getSession().update(user);
    }

    public boolean validatePassword(Integer id, String password) {
        String hql="SELECT userPwd FROM UserEntity WHERE id=:userId";
        Query query=getSession().createQuery(hql);
        query.setParameter("userId",id);
        List result=query.list();
        if(result!=null&&result.size()==1 && result.get(0).equals(password))return true;
        return false;
    }

    public void updatePassword(Integer id, String password) {

    }
    @Transactional
    public boolean validateUser(String userName, String password) {
        String hql="FROM UserEntity WHERE userName=:uname AND userPwd=:pwd";
        Query query=getSession().createQuery(hql);
        query.setParameter("uname",userName);
        query.setParameter("pwd",password);
        List result=query.list();
        if(result==null||result.size()==0)return false;
        return true;
    }
    @Transactional
    public List<UserEntity> getAllUser(){
        String hql="FROM UserEntity";
        Query query=getSession().createQuery(hql);
        List<UserEntity>result=query.list();
        return result;
    }
}
