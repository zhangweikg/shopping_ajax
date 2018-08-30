<%@ page import="com.software.domain.UserRegisterInfo" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>

<% request.setCharacterEncoding("utf-8"); %>

<br> <br>

<h1>登录成功！</h1>
<hr>
<p align="center">欢迎<%=(String)session.getAttribute("txt_name")%>到来。。。</p>
<a href="people_info.jsp">个人信息</a>
<br> <br> <br> <br>
<a href="../shopping/show_goods.jsp">我要购物</a>
</body>
</html>
