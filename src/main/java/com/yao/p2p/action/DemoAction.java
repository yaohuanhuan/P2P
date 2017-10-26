package com.yao.p2p.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yao.p2p.b.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by yx on 2017/10/26.
 * hello
 */

@Namespace("/actions")
@ParentPackage("struts-default")
public class DemoAction extends ActionSupport {

    @Action(value = "sayHello", results = {
            @Result(name = "ok", location = "/test2.html"),
            @Result(name = "no", location = "/test.html")
    })
    public String sayHello() {
        User user = new User();
        user.setUsername("伟哥哥");
        user.setPassword("1234");


        //1 加载配置文件获得核心配置对象
        Configuration config = new Configuration().configure();
        //2 获得工厂 SessionFactory，相当于连接池
        SessionFactory factory = config.buildSessionFactory();
        //3获得会话session，相当于链接Connection
        Session session = factory.openSession();
        //4 开启事务
        Transaction transaction = session.beginTransaction();

        //操作
        session.save(user);

        //5 提交事务 | 回滚事务
        transaction.commit();
        //6 释放资源--关闭session
        session.close();
        //7 释放资源--关闭工厂factory
        factory.close();

        if (true) {
            return "ok";
        } else {
            return "no";
        }
    }

}
