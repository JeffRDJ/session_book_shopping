package com.demo;

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

@WebServlet("/shopping")
public class Shopping extends HttpServlet {
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
        HashMap<String, Integer> bookMap =(HashMap <String,Integer>) session.getAttribute("books");
        // bookMap 只能初始化一次
        if (bookMap == null){// 初始化
            bookMap = new HashMap<String,Integer>();
            bookMap.put("1001",0);
            bookMap.put("1002",0);
            bookMap.put("1003",0);

        }
        if (id!=null){
            int cnt = bookMap.get(id);
            bookMap.put(id,cnt+1);
        }
        session.setAttribute("books",bookMap);
        int bookCnt = 0;
        // 图书总数
        if (session.getAttribute("books")!=null) {
            Set<String> keys = bookMap.keySet();
            for (String key:keys){
                bookCnt+=bookMap.get(key);
            }
        }
        out.println("<head>\n" +
                "<meta http-equiv=\"content-type\" content=\"text/html;charset=UTF-8\">\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>购物车</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>图书列表</h1>\n" +
                "<hr>\n" +
                "<img src=\"imgs/cart.jpg\" height=\"100\"/><a href=\""+"cart.view"+"\">已采购图书"+bookCnt+"本</a>\n" +
                "<p>\n" +
                "    <img src=\"imgs/book1.jpg\" height=\"200\"/> <a href=\"?id=1001\"> 采购此书</a>\n" +
                "    <img src=\"imgs/book2.jpg\" height=\"200\"/><a href=\"?id=1002\"> 采购此书</a>\n" +
                "    <img src=\"imgs/book3.jpg\" height=\"200\" /><a href=\"?id=1003\"> 采购此书</a>\n" +
                "\n" +
                "\n" +
                "</body>");
    }
}
