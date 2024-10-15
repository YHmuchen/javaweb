<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
</head>
<body>
<h2>注册</h2>
<form action="/liu/RegisterUserServlet" method="post">
    用户名: <input type="text" name="username" required><br>
    密码: <input type="password" name="password" required><br>
    <input type="submit" value="注册">
</form>
</body>
</html>