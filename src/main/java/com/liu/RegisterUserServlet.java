package com.liu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/liu/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 保存用户数据到ServletContext（可以用更好的方式保存到数据库）
        getServletContext().setAttribute(username, password);

        // 重定向到登录页面
        response.sendRedirect("login.jsp");
    }
}
