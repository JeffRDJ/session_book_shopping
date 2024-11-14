package com.demo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();


        String user = req.getParameter("username");
        String password = req.getParameter("password");
       // System.out.println(user +"--"+password);

        Enumeration<String> names = req.getParameterNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            System.out.println(name+"="+req.getParameter(name));
        }


        out.println("<!DOCTYPE html>");
        if("tom".equals(user)&&"123".equals(password)){
            out.println("login success!");
        }else{
            out.println("login false!");
            // 返回链接
//            out.println("<p><a href='login.html'>return login</a>");
            out.println("<p><a href='login.html'>返回登录</a>");
        }
    }

}
