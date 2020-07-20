package com.wang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class sessiondemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置服务器端以UTF-8编码进行输出
        resp.setCharacterEncoding("UTF-8");
        //设置从request中取得的值或从数据库中取出的值
        req.setCharacterEncoding("UTF-8");
        //设置浏览器以UTF-8编码进行接收,解决中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");
//        //Session创建的时候做了什么事情
//        Cookie cookie = new Cookie("JSESSIONID", "sessionId");
//        resp.addCookie(cookie);
        HttpSession session = req.getSession();

        session.setAttribute("name","wlq");
        String id = session.getId();
        if(session.isNew()){
            resp.getWriter().write("session创建成功，id："+id);

        }else {
            resp.getWriter().write("session已经存在，id："+id);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
