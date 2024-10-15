package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;

@WebServlet(name = "MyServlet", urlPatterns = {"/login"}, initParams = {
        @WebInitParam(name = "paramName", value = "paramValue")})
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // 设置响应内容类型和字符编码
        response.setContentType("text/html;charset=UTF-8");

        // 获取PrintWriter对象用于向客户端输出响应数据
        PrintWriter out = response.getWriter();
        // 输出响应数据
        out.println("Hello servlet");
    }
}