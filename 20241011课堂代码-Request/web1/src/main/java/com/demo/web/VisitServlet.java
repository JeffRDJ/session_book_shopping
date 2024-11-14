package com.demo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/visit")
public class VisitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        //out.println("VisitServlet---");
        // 1. 客户端几点几分来访, 时间注意格式化
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowStr = sdf.format(now);
        out.println("visit time: " + nowStr);
        // 2. 获取客户端的ip
        String ip = req.getRemoteAddr();
        out.println("your ip: " + ip);
        System.out.println("your ip: " + ip);
        // 3. 客户的查询字符串（Query String）
        out.println("Query String: " + req.getQueryString());
    }
}
