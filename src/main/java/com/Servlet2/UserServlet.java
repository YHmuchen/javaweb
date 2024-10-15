package com.Servlet2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/LoginCheck")
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 注释掉设置编码的代码
        // resp.setContentType("text/html;charset=UTF-8");
        // req.setCharacterEncoding("utf-8");

        // 实例化PrintWriter用于向客户端输出响应
        PrintWriter out = resp.getWriter();

        try {
            // 获取单个参数
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            // 显示单个参数信息
            out.println("<html><body>");
            out.println("<h2>请求参数信息如下:</h2>");
            out.println("<p>username: " + username + "</p>");
            out.println("<p>password: " + password + "</p>");

            // 遍历所有参数
            out.println("<h2>所有请求参数信息如下:</h2>");
            out.println("<ul>");
            Enumeration<String> parameterNames = req.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String paramName = parameterNames.nextElement();
                String paramValue = req.getParameter(paramName);
                out.println("<li>" + paramName + ": " + paramValue + "</li>");
            }
            out.println("</ul>");
            out.println("</body></html>");
        } finally {
            // 关闭PrintWriter
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}