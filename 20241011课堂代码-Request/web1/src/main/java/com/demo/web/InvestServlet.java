package com.demo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/invest.do")
public class InvestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>问卷调查结果</h1>");
        String username = req.getParameter("username");
        out.println("姓名：" + username);
        out.println("<p>性别：" + req.getParameter("gender"));
        out.println("<p>兴趣：");
        String[] interests = req.getParameterValues("interests");
        for (String s : interests  ){
            out.println(s);
        }
        out.println("<p>个人简介：" + req.getParameter("intro"));
    }
}
