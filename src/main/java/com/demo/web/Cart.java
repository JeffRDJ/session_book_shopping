package com.demo.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

@WebServlet("/cart.view")
public class Cart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        req.getParameter("id");
        // 获取session
        HttpSession session = req.getSession();
        String id = req.getParameter("id");
        //
        System.out.println(id);
        //session中暂存了书籍信息
        HashMap<String, Integer> bookMap = (HashMap<String, Integer>) session.getAttribute("books");
        int b1 = 0, b2 = 0, b3 = 0;

        session.setAttribute("books", bookMap);
        int bookCnt = 0;
        // 图书总数
        if (session.getAttribute("books") != null) {
            Set<String> keys = bookMap.keySet();
            for (String key : keys) {
                switch (key) {
                    case "1001":
                        b1 += bookMap.get(key);
                        break;
                    case "1002":
                        b2 += bookMap.get(key);
                        break;
                    case "1003":
                        b3 += bookMap.get(key);
                        break;
                }
                bookCnt += bookMap.get(key);
            }
        }

        String html = "<img src=\"imgs/cart.jpg\" height=\"100\"/>已采购" + bookCnt + "本图书<p>\n" +
                "<table border=\"1\">\n" +
                "     <tr>\n" +
                "         <td><img src=\"imgs/book1.jpg\" height=\"100\"/></td>\n" +
                "         <td width=\"100\">  共" + b1 + "本</td>\n" +
                "     </tr>\n" +
                "     <tr>\n" +
                "         <td><img src=\"imgs/book2.jpg\" height=\"100\" /></td>\n" +
                "         <td width=\"100\">  共" + b2 + "本</td>\n" +
                "     </tr>\n" +
                "     <tr>\n" +
                "         <td><img src=\"imgs/book3.jpg\" height=\"100\" /></td>\n" +
                "         <td width=\"100\">  共" + b3 + "本</td>\n" +
                "     </tr>\n" +
                "</table>";
        out.println(html);

    }
}
