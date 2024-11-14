package com.demo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Hello Servlet!");
        out.println(req.getMethod());
        out.println(req.getRequestURI());
        out.println(req.getRequestURL());
        out.println(req.getContextPath());
        out.println(req.getServletPath());
        out.println(req.getLocalPort());

        out.println("==================================");

        Enumeration<String> names = req.getHeaderNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            out.println(name+"--"+req.getHeader(name));
        }

    }
}
