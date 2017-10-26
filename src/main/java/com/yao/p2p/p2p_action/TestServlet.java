package com.yao.p2p.p2p_action;

import com.yao.p2p.b.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yx on 2017/10/26.
 * hello
 */
public class TestServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ac.getBean("user");
        resp.getWriter().write("ni hao p2p_action !"+user);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
