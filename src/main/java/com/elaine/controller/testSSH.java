package com.elaine.controller;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class testSSH {
    private ApplicationContext ctx=null;
    @Test
    public void testDataSource() throws SQLException {
        ctx=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        System.out.println("数据源:"+ctx);
        DataSource dataSource=ctx.getBean(DataSource.class);
        System.out.println("open datasource:"+dataSource.getConnection().toString());
        SessionFactory sessionFactory=ctx.getBean(SessionFactory.class);
        System.out.println("sessionFactory:"+sessionFactory);
    }
}
