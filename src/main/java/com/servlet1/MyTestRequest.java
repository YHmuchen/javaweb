package com.servlet1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyTestRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // 设置响应内容类型和字符编码
        response.setContentType("text/html;charset=UTF-8");

        // 获取PrintWriter对象用于向客户端输出响应数据
        PrintWriter out = response.getWriter();

        // 获取请求行信息
        String requestURL = request.getRequestURL().toString();
        String requestURI = request.getRequestURI();
        String queryString = request.getQueryString();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String remoteAddr = request.getRemoteAddr();

        // 获取本地IP地址
        String localIP = "未知";
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            localIP = localHost.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // 解决中文参数的乱码问题
        String name = "";
        if (queryString != null && queryString.contains("name=")) {
            try {
                queryString = java.net.URLDecoder.decode(queryString, "UTF-8");
                int startIndex = queryString.indexOf("name=") + 5;
                int endIndex = queryString.indexOf("&", startIndex);
                if (endIndex == -1) {
                    name = queryString.substring(startIndex);
                } else {
                    name = queryString.substring(startIndex, endIndex);
                }
            } catch (java.io.UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        // 输出响应数据
        out.println("getRequestURL: " + requestURL + "<br>");
        out.println("getRequestURI: " + requestURI + "<br>");
        out.println("getQueryString: " + queryString + "<br>");
        out.println("name: " + name + "<br>");
        out.println("getServerName: " + serverName + "<br>");
        out.println("getServerPort: " + serverPort + "<br>");
        out.println("getRemoteAddr: " + remoteAddr + "<br>");
        out.println("getLocalAddr: " + localIP);
    }
}