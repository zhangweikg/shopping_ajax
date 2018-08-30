<%--
  Created by IntelliJ IDEA.
  User: zhangweikang
  Date: 5/19/18
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>
    注册失败！<br>
    3秒后请重新注册！
    <%
        response.setHeader("Refresh", "3;url=register.jsp");
    %>

</h1>
</body>
</html>
