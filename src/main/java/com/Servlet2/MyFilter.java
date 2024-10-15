package com.Servlet2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "MyFilter", urlPatterns = "/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Filter初始化时执行，可以在这里做一些初始化工作
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 强制转换请求和响应对象
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 设置请求编码
        req.setCharacterEncoding("utf-8");

        // 设置响应编码
        resp.setContentType("text/html;charset=utf-8");

        // 继续执行下一个过滤器或目标资源（如servlet/jsp）
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Filter销毁时执行，可以在这里做一些清理工作
    }
}