package com.wang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class cookiedemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        解决中文乱码
        //设置服务器端以UTF-8编码进行输出
        req.setCharacterEncoding("UTF-8");
        //设置浏览器以UTF-8编码进行接收,解决中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");


        PrintWriter out= resp.getWriter();

        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
//如果存在cookie
            out.write("你上一次访问的时间是：");
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("last_login_time")) {
                    long lastlogintime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastlogintime);
                    out.write(date.toLocaleString());

                }
            }
        }else{
            out.write("这是您第一次访问本站");
        }

        Cookie cookie = new Cookie("last_login_time", System.currentTimeMillis() + "");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);


    }


}
