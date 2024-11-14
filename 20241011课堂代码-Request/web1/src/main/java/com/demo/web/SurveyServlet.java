package com.demo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/survey.do")
public class SurveyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String gender = req.getParameter("gender");
        out.println("<h3>你的调查结果：</h3>");
        out.println("性别："+gender);
        String[] interests = req.getParameterValues("interest");
        //增强型的for循环
        out.println("<p>兴趣：");
        for(String i:interests){
            out.println(i);
        }

        out.println("<p>个人简介：");
        out.println(req.getParameter("introducation"));




      /*  for (int i = 0; i < interests.length ; i++) {
            System.out.println(interests[i]);
        }*/

    }

}
