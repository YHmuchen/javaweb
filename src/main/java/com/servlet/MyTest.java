package com.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // 设置响应内容类型和字符编码
        response.setContentType("text/html;charset=UTF-8");

        // 获取PrintWriter对象用于向客户端输出响应数据
        PrintWriter out = response.getWriter();
        // 获取请求路径
        String requestURI = request.getRequestURI();

        // 输出响应数据
        out.println("访问成功，请求路径为:" + requestURI);
    }
}