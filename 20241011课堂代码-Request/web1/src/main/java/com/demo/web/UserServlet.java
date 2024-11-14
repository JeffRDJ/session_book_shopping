package com.demo.web;

import com.demo.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        // 接收客户端发送的请求参数
        String id = req.getParameter("id");
        String pwd = req.getParameter("password");
        // 调试，在控制台打印参数
       // System.out.println(id);
       // out作用：反馈回客户端数据，客户端浏览器接收到数据，会按HTML进行解析
        User user = new User(id,pwd);
        out.println(user);
    }
}
