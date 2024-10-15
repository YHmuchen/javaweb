package com.liu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/liu/LoginUserServlet")
public class LoginUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 获取注册时保存的用户数据
        String storedPassword = (String) getServletContext().getAttribute(username);

        // 验证用户名和密码
        if (storedPassword != null && storedPassword.equals(password)) {
            // 登录成功，重定向到主页
            response.sendRedirect("homepage.jsp");
        } else {
            // 登录失败，返回登录页面并显示错误消息
            request.setAttribute("errorMessage", "无效的用户名或密码。\n");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
