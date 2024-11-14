package com.demo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/invest.do")
public class InvestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        out.println("<1>问卷调查结果</1>");
        String username=req.getParameter("username");
        out.println("姓名：" + username);
        out.println("<p>性别：" + req.getParameter("gender"));
        out.println("<p>兴趣：");
        String[] interests = req.getParameterValues("interests");
        for(String interest:interests){
            out.println(interest);
        }
        out.println("<p>个人简介：" + req.getParameter("intro"));
    }

}
