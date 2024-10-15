<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<h2>登录</h2>
<form action="LoginUserServlet" method="post">
    用户名: <input type="text" name="username" required><br>
    密码: <input type="password" name="password" required><br>
    <input type="submit" value="登录">
</form>
<%
    // 获取可能存在的错误消息
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null && !errorMessage.isEmpty()) {
%>
<p><%= errorMessage %></p>
<%
    }
%>
</body>
</html>